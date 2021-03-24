package com.cg.trg.exception;

import java.util.Arrays;
/**
 * 
 * @author Shruti
 * This is an User Defined Exception Class-Payment Exception class extending Exception
 *
 */
public class PaymentException extends Exception{
	
	public PaymentException() {
		
	}
	
	public PaymentException(String message) {
		super(message);
		
	}

	@Override
	public String toString() {
		return "EmployeeException:" + super.getMessage();
	}
	

}
