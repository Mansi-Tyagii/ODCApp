package com.cg.trg.exception;
/**
 * 
 * @author Pravartika
 * This is an User Defined Exception Class-Customer Exception class extending Exception
 *
 */
public class CustomerException extends Exception{

		public CustomerException() {

		}


		public CustomerException(String message) {
				super(message);
		}


		@Override
		public String toString() {
			return "CustomerException:" + super.getMessage();
		}
	}


