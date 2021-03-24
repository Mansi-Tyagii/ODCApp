package com.cg.trg.exception;
/**
 * 
 * @author Shivam
 * This is an User Defined Exception Class-Item Charges Exception class extending Exception
 *
 */
public class ItemChargesException extends Exception {
	public ItemChargesException() {

	}

	public ItemChargesException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return "ItemChargesException:" + super.getMessage();
	}



}
