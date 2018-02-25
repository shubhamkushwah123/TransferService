package org.payments.assignment.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Account {
	
	@Id
	private long accountNumber;
	
	private double balance;
	
	private String accountHolderName;
	
	
	//	paramaterized constructor
	public Account(long accountNumber, double balance, String accountHolderName) {
		this.accountNumber=accountNumber;
		this.balance = balance;
		this.accountHolderName=accountHolderName;
	}

	//  default constructor
	public Account() {
		
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	
	

}