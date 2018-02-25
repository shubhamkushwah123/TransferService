package org.payments.assignment.service;

import java.util.List;

import org.payments.assignment.entity.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
	
	public List<Account> getAllAccounts();
	
	public boolean isExist(Account account);
	
	public Account createAccount(Account account);
	
	public Account getAccount(long accountNumber);

}
