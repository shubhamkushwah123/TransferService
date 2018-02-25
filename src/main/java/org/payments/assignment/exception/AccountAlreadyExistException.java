package org.payments.assignment.exception;

public class AccountAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8209220781250918827L;

	/**
	 * 
	 */
	public AccountAlreadyExistException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public AccountAlreadyExistException(String msg) {
		
		super(msg);
		
	}

	
}