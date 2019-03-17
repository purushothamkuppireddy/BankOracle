package com.bank.transactiondao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankTransactionDaoImplTest {
static BankTransactionDaoImpl dao=new BankTransactionDaoImpl();
	

	@Test
	void testDeposit() {
		assertEquals(1,dao.deposit(1000002,100,200));
	}
	@Test
	void testWithdraw() {
		assertEquals(1,dao.withdraw(1000007,500,100));
	}

	@Test
	void testFundTransfer() {
		assertEquals(1,dao.fundTransfer(1000010,300,1000000, 100));
	}

}
