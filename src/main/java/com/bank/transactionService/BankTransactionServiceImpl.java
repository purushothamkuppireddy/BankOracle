package com.bank.transactionService;

import com.bank.model.Account;
import com.bank.transactiondao.BankTransactionDaoImpl;

public class BankTransactionServiceImpl implements BankTransactionService{

	static BankTransactionDaoImpl transdao=new BankTransactionDaoImpl();
	
	
	public int withdraw(long accountNo, int amount) {
		int m=transdao.withdraw(accountNo,amount);
		return m;
	}

	public int deposit(long accountNo, int amount) {
		int n=transdao.deposit(accountNo,amount);
		return n;
	}

	public int fundTransfer(long fromAccountNo, int amount, Long toAccountNo) {
		int k=transdao.fundTransfer(fromAccountNo,amount,toAccountNo);
		return k;
	}

}
