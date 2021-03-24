package com.cg.trg.exception;
/**
 * 
 * @author Shivam
 * This is an User Defined Exception Class-Booking Item Exception class extending Exception
 *
 */
public class BookingItemException extends Exception{

	public BookingItemException() {

	}


	public BookingItemException(String message) {
			super(message);
	}


	@Override
	public String toString() {
		return "BookingItemException:" + super.getMessage();
	}
	
	


}
