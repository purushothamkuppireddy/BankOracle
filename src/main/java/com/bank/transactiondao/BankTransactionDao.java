package com.bank.transactiondao;

public interface BankTransactionDao {
	public int withdraw(long accountNo, int amount);
	public int deposit(long accountNo, int amount);
	public int fundTransfer(long fromAccountNo,int amount,Long toAccountNo);
}
