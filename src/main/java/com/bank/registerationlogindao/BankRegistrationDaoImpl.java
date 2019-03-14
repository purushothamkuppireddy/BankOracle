package com.bank.registerationlogindao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bank.model.Account;

public class BankRegistrationDaoImpl implements BankRegistrationDao {
	Account account = new Account();
	Scanner sc = new Scanner(System.in);
//registration
	public long registration(Account account) {

		long accNo = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "capg", "oracle123");
			PreparedStatement ps = con.prepareStatement("insert into customer_details values(account_sql.nextval,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, account.getFirstName());
			ps.setString(2, account.getLastName());
			ps.setString(3, account.getEmailId());
			ps.setInt(4, account.getPassword());
			ps.setInt(5, account.getPancardNo());
			ps.setLong(6, account.getAadharNo());
			ps.setString(7, account.getAddress());
			ps.setLong(8, account.getMobileNo());
			ps.setDouble(9, 0);
			ps.executeUpdate();
			System.out.println("Inserted");

			PreparedStatement ps2 = con.prepareStatement("select * from customer_details where aadhar_no=?");
			ps2.setLong(1, account.getAadharNo());
			ResultSet rs = ps2.executeQuery();
			while (rs.next()) {
				accNo = rs.getLong(1);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accNo;
	}

//Login	
	public Account Login(long accountNo,int password) 
	{int count=0;
	
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","capg","oracle123");
		PreparedStatement ps=con.prepareStatement("select * from customer_details where account_no=? and password=?");
		ps.setLong(1,accountNo);
		ps.setLong(2,password);
		ResultSet rs = ps.executeQuery();	
		while(rs.next()) {
			
			account.setBalance(rs.getInt(10));
			//b=true;
			count++;
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(count==0)
		return null;
	else
		return account;
	}
	

//validate method	
	public boolean validate(long aadharNo)
	{
		boolean b=false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","capg","oracle123");
			PreparedStatement ps=con.prepareStatement("select * from customer_details where aadhar_no=?");
			ps.setLong(1,aadharNo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				b=true;
			}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	
		
		

}

