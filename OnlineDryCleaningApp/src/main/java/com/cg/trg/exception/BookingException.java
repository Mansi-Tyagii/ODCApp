package com.cg.trg.exception;
/**
 * 
 * @author Mansi
 * This is an User Defined Exception Class-Booking Exception class extending Exception
 *
 */
public class BookingException extends Exception{
	public BookingException() {

	}


	public BookingException(String message) {
			super(message);
	}


	@Override
	public String toString() {
		return "BookingException:" + super.getMessage();
	}

}
