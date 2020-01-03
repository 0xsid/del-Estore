package com.deloitte.estore.util;

public class InvalidProductNameException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidProductNameException(String message) {
		super(message);
	}
}
