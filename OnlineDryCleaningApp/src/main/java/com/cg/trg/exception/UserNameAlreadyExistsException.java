package com.cg.trg.exception;
/**
 * 
 * @author Mrunal
 * This is an User Defined Exception Class-User Name Already Exists Exception class extending Exception
 *
 */
public class UserNameAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	public UserNameAlreadyExistsException(String errorMessage) {
	
		super(errorMessage);
	}
	@Override
	public String toString() {
		return "UserNameAlreadyExistsException" + super.getMessage();
	}

}
