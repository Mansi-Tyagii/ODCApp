package com.cg.trg.exception;
/**
 * 
 * @author Mrunal
 * This is an User Defined Exception Class-User Exception class extending Exception
 *
 */
public class UserException extends Exception {

	public UserException() {

	}

	public UserException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return "UserException:" + super.getMessage();
	}


}
