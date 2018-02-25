package org.payments.assignment.service;

import java.util.ArrayList;
import java.util.List;
import org.payments.assignment.dao.TransferServiceDao;
import org.payments.assignment.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SHUBHAM
 * 
 * AccountServiceImpl provides an implementation of AccountService Interface. It offers various features like
 * 1) create new account
 * 2) update account
 * 3) retrieve all account
 * 4) check, if account already exists
 */
@Service
public class AccountServiceImpl implements AccountService {

	
	@Autowired
	TransferServiceDao transferServiceDao;

	
	public Account createAccount(Account account) {
		return transferServiceDao.addAccount(account);
	}
	
	
	public Account getAccount(long accountNumber) {
		return transferServiceDao.getAccount(accountNumber);
	}

	
	public boolean isExist(Account account) {
		Account fetchedAccount = getAccount(account.getAccountNumber());
		if(fetchedAccount==null) {
			return false;
		}
		else {
			return true;
		}
	}	
	
	public List<Account> getAllAccounts(){
		List<Account> listOfAccounts = new ArrayList<Account>();
		listOfAccounts = transferServiceDao.getAllAccounts();
		return listOfAccounts;
	}

}
