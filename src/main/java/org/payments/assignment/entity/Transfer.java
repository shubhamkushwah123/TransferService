package org.payments.assignment.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transfer {
	
	@Id @GeneratedValue
	private long id;
	
	private long senderAccountNumber;
	
	private long receiverAccountNumber;
	
	private double amount;
	
	private Date timestamp;
	
	private String status;
	
	
	//paramaterized constructor
	public Transfer( long senderAccountNumber, long receiverAccountNumber, double amount) {
		this.senderAccountNumber = senderAccountNumber;
		this.receiverAccountNumber = receiverAccountNumber;
		this.amount = amount;
		this.timestamp = new Date();
		this.status="";
	}
	//default constructor
	public Transfer() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSenderAccountNumber() {
		return senderAccountNumber;
	}

	public void setSenderAccountNumber(long senderAccountNumber) {
		this.senderAccountNumber = senderAccountNumber;
	}

	public long getReceiverAccountNumber() {
		return receiverAccountNumber;
	}

	public void setReceiverAccountNumber(long receiverAccountNumber) {
		this.receiverAccountNumber = receiverAccountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
