package org.payments.assignment.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.payments.assignment.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceTest extends TestSpringBootApplication {
	
	private static final Logger log = LoggerFactory.getLogger(AccountServiceTest.class);	
	
	@Autowired
	private AccountService accountService;
	
	
	@Test
	public void testGetAllAccounts() {
		log.info("Testing getAllAccounts()");
		List<Account> accountList = new ArrayList<Account>();
		accountList = accountService.getAllAccounts();
		Assert.assertNotNull("failure - executed not Null", accountList);
	}
	
	@Test 
	public void testGetAccount() {
		log.info("Testing getAccount()");
		Account fetchedAccount = accountService.getAccount(123456789);
		Assert.assertNotNull(fetchedAccount);
		Assert.assertEquals("AccountHolder Name should be Shubham", "Shubham", fetchedAccount.getAccountHolderName());
		Assert.assertEquals(5000.0, fetchedAccount.getBalance(),0);
	}
	
	@Test
	public void testAddAccount() {
		log.info("Testing addAccount()");
		Account account = new Account(999888444, 1000 , "Sam");
		accountService.createAccount(account);
		Assert.assertTrue(accountService.getAccount(999888444)!=null);
	}
	
	@Test
	public void testIfAccountAlreadyExists() {
		log.info("Testing, if account alrady exists()");
		Account account = new Account(123456789, 5000, "Shubham");
		Assert.assertTrue(accountService.isExist(account));
	}
}
