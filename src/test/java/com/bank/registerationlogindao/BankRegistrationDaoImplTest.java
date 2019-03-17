package com.bank.registerationlogindao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.junit.jupiter.api.Test;

import com.bank.model.Account;

class BankRegistrationDaoImplTest {

	static BankRegistrationDaoImpl dao=new BankRegistrationDaoImpl();
	static Account account=new Account();
	
//	@Test
//	void testRegistration() {
//		account.setAadharNo(987745);
//		account.setFirstName("vijay");
//		account.setLastName("reddy");
//		account.setEmailId("vijay@gmail.com");
//		account.setPancardNo(44565);
//		account.setMobileNo(845513);
//		account.setPassword(12345);
//		account.setAddress("hyd");
//		assertEquals(1000008, dao.registration(account));
//	
//	}

	@Test
	void testLogin() {
		assertEquals(null, dao.Login(1000001,8454) );
	}
	
	@Test
	void testvalidate()
	{long adhar=9877;
		assertEquals(true, dao.validate(adhar));
	}

}
