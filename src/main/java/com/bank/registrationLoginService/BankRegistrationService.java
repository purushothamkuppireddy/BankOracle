package com.bank.registrationLoginService;

import com.bank.model.Account;

public interface BankRegistrationService {
	public Account Login(long accountNo,int password);
	public long registration(Account account);
	public boolean validate(long aadharNo);
}
