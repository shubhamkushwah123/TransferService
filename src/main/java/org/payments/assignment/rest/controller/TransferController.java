package org.payments.assignment.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.payments.assignment.constants.TransferServiceConstants;
import org.payments.assignment.entity.Account;
import org.payments.assignment.entity.Transfer;
import org.payments.assignment.exception.AccountAlreadyExistException;
import org.payments.assignment.exception.ValidationException;
import org.payments.assignment.service.AccountService;
import org.payments.assignment.service.TransferService;
import org.payments.assignment.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SHUBHAM
 * TransferController is the Rest Api to handle all the request from the client and sends a response back. This is capable of
 * handling 4 endpoint urls
 * 
 *  /transfer-api/getAllAccounts - to get the list of all accounts.
 *  /transfer-api/getAllTransactions - to get the list of all transactions.
 *  /transfer-api/createAccount - to create an Account
 *  /transfer-api/transfer  - to transfer money from one account to another account
 * 
 */
@RestController
@RequestMapping("/transfer-api")
public class TransferController {
	
	@Autowired
	private TransferService transferService;
	
	@Autowired
	private ValidationService validator;
	
	@Autowired
	private AccountService accountService;

   
	
	@RequestMapping(method=RequestMethod.POST, value="/createAccount")
	public ResponseEntity<Object> createAccount(@RequestBody Account account) throws Exception {
		Account createdAccount = new Account();
		try {
			if(account.getAccountNumber()==0 || account.getAccountHolderName()==null) {
				throw new Exception(TransferServiceConstants.NEGATIVE_AMOUNT);
			}
			else {
					if(accountService.isExist(account)) {
						throw new AccountAlreadyExistException(TransferServiceConstants.ACCOUNT_ALREADY_EXISTS);
					}
					else {
						createdAccount=accountService.createAccount(account);
					}
			}
		} catch(Exception e) {
			throw new Exception(e);
		}
		return new ResponseEntity<Object>(accountService.getAllAccounts(), HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/transfer")
	public ResponseEntity<Object> transferMoney(@RequestBody Transfer transaction){
		System.out.println("transfer executing");
		Account senderAccount = new Account();
		try {
		if(validator.validate(transaction)) {
			senderAccount=transferService.executeTransaction(transaction);
		}
		}
		catch(Exception e)
		{
			throw new ValidationException(e.getMessage());
		}
		
		return new ResponseEntity<Object>(senderAccount, HttpStatus.CREATED);
		
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="getAllAccounts")
	public ResponseEntity<Object> getAllAccount() throws Exception{
		List<Account> listOfAccounts = new ArrayList<Account>();
		try {
		listOfAccounts = accountService.getAllAccounts();
		}catch(Exception e) {
			throw new Exception(e);
		}
		return new ResponseEntity<Object>(listOfAccounts,HttpStatus.OK);	
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="getAllTransactions")
		public ResponseEntity<Object> getAllTransfers() throws Exception{
		List<Transfer> listOfTransfers = new ArrayList<Transfer>() ;
		try {
			listOfTransfers = transferService.getAllTransfers();
		}catch(Exception e) {
			throw new Exception(e);
		}
		return new ResponseEntity<Object>(listOfTransfers, HttpStatus.OK);
	}
	
	
}
