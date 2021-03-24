package com.cg.trg.exception;
/**
 * 
 * 
 * This is an User Defined Exception Class-Feedback Exception class extending Exception
 *
 */
public class FeedbackException extends Exception{
	
	public FeedbackException() {
		
	}
	
	public FeedbackException(String message) {
		super(message);
		
	}

	@Override
	public String toString() {
		return "FeedbackException:" + super.getMessage();
	}
	

}

