package org.payments.assignment.exception;


public class InsufficientFundsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1696052598811222230L;

	/**
	 * @param message
	 */

	public InsufficientFundsException(String message) {
		super(message);
		
	}

	public InsufficientFundsException() {
		// TODO Auto-generated constructor stub
	}

	
}
