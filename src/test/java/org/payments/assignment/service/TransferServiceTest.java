package org.payments.assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.payments.assignment.entity.Account;
import org.payments.assignment.entity.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
public class TransferServiceTest extends TestSpringBootApplication{

	
	@Autowired
	private TransferService transferService;
	
	@Autowired
	private AccountService accountService;
	
	@Test
	public void testGetAllTransaction() {
		List<Transfer> transactionList = new ArrayList<Transfer>();
		transactionList=transferService.getAllTransfers();
		Assert.assertNotNull("failure, if null",transactionList);
	}
	
	@Test
	public void testMoneyTransfer() throws Exception {
		Transfer transfer = new Transfer();
		transfer.setSenderAccountNumber(557684573);
		transfer.setReceiverAccountNumber(889987343);
		transfer.setAmount(5000);
		transferService.executeTransaction(transfer);
		Account senderAccount = accountService.getAccount(557684573);
		Account receiverAccount = accountService.getAccount(889987343);
		Assert.assertEquals("check remaining balance in sender account", 5000.0, senderAccount.getBalance(),0 );
		Assert.assertEquals("check total balance in reciever account", 13000.0 , receiverAccount.getBalance(),0);
	}
}
