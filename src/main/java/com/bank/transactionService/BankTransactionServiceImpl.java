package com.bank.transactionService;

import com.bank.model.Account;
import com.bank.transactiondao.BankTransactionDaoImpl;

public class BankTransactionServiceImpl implements BankTransactionService{

	static BankTransactionDaoImpl transdao=new BankTransactionDaoImpl();
	
	
	public int withdraw(long accountNo, int amount,int amt) {
		int m=transdao.withdraw(accountNo,amount,amt);
		return m;
	}

	public int deposit(long accountNo, int amount,int amt) {
		int n=transdao.deposit(accountNo,amount,amt);
		return n;
	}

	public int fundTransfer(long fromAccountNo, int amount, long toAccountNo,int amt) {
		int k=transdao.fundTransfer(fromAccountNo,amount,toAccountNo,amt);
		return k;
	}

	public boolean validateAadhar(long aadharNo) {
		long n=aadharNo;
		
		if(Long.toString(n).length()==12)
			
			return true;	
		/*	
		int count=0;
		int rem=0;
		while(n>0)
		{
		 rem=(int) (n%10);
			n=n/10;
			count++;
		}
		if(count==12)*/
		
	else
		return false;
	}

}
