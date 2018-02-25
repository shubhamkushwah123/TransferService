package org.payments.assignment.entity;

import java.util.Date;

/**
 * @author SHUBHAM
 * 
 * ErrorDetails is a bean that holds the generic information that would be shown to the user about all the exceptions
 */
public class ErrorDetails {
	
	private Date timestamp;

	private String message;
	
	private String details;

	/**
	 * @param timestamp
	 * @param message
	 * @param details
	 */
	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
