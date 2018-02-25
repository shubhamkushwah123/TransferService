package org.payments.assignment.dao;

import java.util.ArrayList;
import java.util.List;
import org.payments.assignment.entity.Account;
import org.payments.assignment.entity.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SHUBHAM
 * 
 * TransferServiceDao allows server layer to connect to data layer using Spring JPA.
 *
 */
@Service
public class TransferServiceDao {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public List<Account> getAllAccounts(){
		List<Account> accounts = new ArrayList<>();
		accountRepository.findAll().forEach(accounts::add);
		return accounts;
	}
	
	public Account addAccount(Account account) {
		return accountRepository.save(account);
	}
	
	public Account getAccount(long accountNumber) {
		return accountRepository.findOne(accountNumber);
	}
	
	public void updateAccount(long accountNumber, Account account) {
       accountRepository.save(account);
	}

	public Transfer addTransaction(Transfer transaction) {
		return transactionRepository.save(transaction);
		
	}
	
	public Transfer getTransaction(long id) {
		return transactionRepository.findOne(id);
	}
	
	public void updateTransaction(Transfer transaction) {
		transactionRepository.save(transaction);
	}
	

	public List<Transfer> getAllTransaction() {
		List<Transfer> transactions = new ArrayList<>();
		transactionRepository.findAll().forEach(transactions::add);
		return transactions;
	}
}
