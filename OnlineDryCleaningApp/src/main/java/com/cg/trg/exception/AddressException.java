package com.cg.trg.exception;
/**
 * 
 * @author Pravartika
 * This is an User Defined Exception Class-Address Exception class extending Exception
 *
 */
public class AddressException extends Exception {
	public AddressException() {
	}
	public AddressException(String message) {
		super(message);
}


@Override
public String toString() {
	return "AddressException:" + super.getMessage();
}

	

}