package com.bank.ui;

import java.util.Scanner;

import com.bank.model.Account;
import com.bank.registerationlogindao.BankRegistrationDaoImpl;
import com.bank.registrationLoginService.*;
import com.bank.transactionService.*;
import com.bank.transactiondao.BankTransactionDaoImpl;
import com.bank.userException.WrongCredential;

public class Welcome {
static BankRegistrationServiceImpl serv=new BankRegistrationServiceImpl();
static BankTransactionServiceImpl transserv=new BankTransactionServiceImpl();
static Account account =new Account();
	public static void main(String[] args) {
		int j=1;
		while(j==1) {
	      System.out.println("enter the choice 1:Registration , 2:Login  3:Exit");
	      Scanner sc=new Scanner(System.in);
	    	int ch=sc.nextInt();
	    	switch(ch)
	    	{
	    	case 1://Registration
	    		System.out.println("enter Aadhar no to register");
	    		long aadharNo=sc.nextLong();
	    		boolean bl=serv.validate(aadharNo);
	    		if(bl==false) {
	    		account.setAadharNo(aadharNo);
	    		System.out.println("enter firstname");
	    		account.setFirstName(sc.next());
	    		System.out.println("enter lastname");
	    		account.setLastName(sc.next());
	    		System.out.println("enter emailId");
	    		account.setEmailId(sc.next());
	    		System.out.println("enter password for your account");
	    		account.setPassword(sc.nextInt());
	    		System.out.println("enter pancard number");
	    		account.setPancardNo(sc.nextInt());
	    		System.out.println("enter Address");
	    		account.setAddress(sc.next());
	    		System.out.println("enter mobile No");
	    		account.setMobileNo(sc.nextLong());
	    		long accNo=serv.registration(account);
	    			System.out.println("Account registerd successfully.your accno is: "+accNo);
	    		}
	    			else {
		    			System.out.println("Aadhar no is already existed");
		    			}
	    			break;
	    	
	    	
	    	case 2: //login
	    		System.out.println("enter the Account no and password");
	    		long accountNo=sc.nextLong();
	    		int pwd=sc.nextInt();
	    		account=serv.Login(accountNo,pwd);
	    		 if(account!=null)
	    		 {
	    			 System.out.println("Enter 1:withdraw  2: Deposit  3:Fund transfer  4:Show balance ");
	    			 int ch2=sc.nextInt();
	    			 switch(ch2)
	    			 {
	    			 case 1: //withdraw
	    				 	int m=transserv.withdraw(accountNo,account.getBalance());
	    				 	if(m==1) System.out.println("withdrawl successfully");
	    				 	else System.err.println("error in withdrawl");
	    				 	break;
	    				 
	    			 case 2: // deposit
	    				 	int n=transserv.deposit(accountNo,account.getBalance());
	    				 	if(n==1) System.out.println("deposited successfully");
	    				 	else System.err.println("error in depositing");
	    				 	break;
	    				 	
	    			 case 3: //fund transfer
	    				 System.out.println("enter the accno to which transfer to be happen");
	    				 long accountNo2=sc.nextLong();
	    				 int k=transserv.fundTransfer(accountNo,account.getBalance(),accountNo2);
	    				 if(k==1)
	 						System.err.println("successfully inserted into transaction table");
	 					else
	 						System.err.println("Error in inserting into transaction table");
	 					
	    				 
	    			 case 4: //show balance	 
	    				 System.out.println("current account balance is: "+account.getBalance());
	    			 }
	    		 }
	    		 else
	    		 {
	    			 try {
							throw new WrongCredential();
						} catch (Exception e) {
							
						}
	    		 }
	    			 
	    			 break;
	    	case 3:System.out.println("Thank You..");
	    			System.exit(0);
	    	
	    	}
	    	
	}
	}

}
