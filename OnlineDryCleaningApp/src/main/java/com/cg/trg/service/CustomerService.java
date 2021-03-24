package com.cg.trg.service;

import java.util.List;

import com.cg.trg.entity.Customer;
import com.cg.trg.exception.CustomerException;
/**
 * 
 * @author Pravartika
 * This is Customer Service  Interface Class.
 * Contains Add,Remove,Update,Get and GetAll methods
 * 
 */
public interface CustomerService {
	public Customer addCustomer(Customer customer)throws CustomerException;
	public void removeCustomer(Long customerId)throws CustomerException;
	public Customer updateCustomer(Customer customer)throws CustomerException;
	public Customer getCustomer(Long customerId)throws CustomerException;
	public List<Customer> getAllCustomers()throws CustomerException; 
}
