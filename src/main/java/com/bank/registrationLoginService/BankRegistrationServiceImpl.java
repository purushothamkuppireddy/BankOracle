package com.bank.registrationLoginService;

import com.bank.model.Account;
import com.bank.registerationlogindao.BankRegistrationDaoImpl;

public class BankRegistrationServiceImpl implements BankRegistrationService {
	static BankRegistrationDaoImpl dao=new BankRegistrationDaoImpl(); 
	static Account account=new Account(); 
	
	public Account Login(long accountNo, int password) {
		account= dao.Login(accountNo,password);
		return account;
	}

	public long registration(Account account) {
		long accNo=dao.registration(account);
		return accNo;
	}
	public boolean validate(long aadharNo) {
		boolean bl=dao.validate(aadharNo);
		return bl;
	}

	
}
