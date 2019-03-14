package com.bank.registerationlogindao;

import com.bank.model.Account;

public interface BankRegistrationDao {
	public Account Login(long accountNo,int password);
	public long registration(Account account);
	
}
