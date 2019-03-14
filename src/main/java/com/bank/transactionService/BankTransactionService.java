package com.bank.transactionService;

public interface BankTransactionService {
	public int withdraw(long accountNo, int amount);
	public int deposit(long accountNo, int amount);
	public int fundTransfer(long fromAccountNo,int amount,Long toAccountNo);
}
