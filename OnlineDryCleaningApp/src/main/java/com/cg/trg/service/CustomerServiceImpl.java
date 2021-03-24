package com.cg.trg.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cg.trg.dao.ICustomerRepositoryDao;
import com.cg.trg.entity.Customer;
import com.cg.trg.exception.CustomerException;


/**
 * 
 * @author Pravartika
 * This is Customer Service Interface Implementation Class.
 * Performing Add,Remove,Update,Get and GetAll methods
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

     @Autowired
     private ICustomerRepositoryDao customerDao;
     /**
      * This method is used to Add Customer Using  Customer Object
      */
	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		try {			
			return customerDao.save(customer);
		}catch(DataAccessException e) {
			//converting SQLException to CustomerException
			throw new CustomerException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to CustomerException
			throw new CustomerException(e.getMessage());
		}
		
	}
	/**
     * This method is used to remove Customer Using  CustomerId Object
     */
	@Override
	public void removeCustomer(Long customerId) throws CustomerException{
		try {
			 customerDao.deleteById(customerId);
		}catch(DataAccessException e) {
			throw new CustomerException(e.getMessage());
		}catch(Exception e) {
			throw new CustomerException(e.getMessage());
		}
	}
	/**
     * This method is used to Update Customer Using  Customer Object
     */
	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
			try {
			System.out.println(customer);
			Optional<Customer> optional= customerDao.findById(customer.getCustomerId());
			if(optional.isPresent()) {
				Customer c= optional.get();
				c.setCustomerName(customer.getCustomerName());
				return customerDao.save(customer);
			}else {
				throw new Exception("Invalid CustomerId");
			}
				
			}catch(DataAccessException e) {
				//converting SQLException to CustomerException
				throw new CustomerException(e.getMessage());
			}catch(Exception e) {
				//converting SQLException to CustomerException
				throw new CustomerException(e.getMessage());
			}
		}
	/**
     * This method is used to get Customer Using  CustomerId
     */
	@Override
	public Customer getCustomer(Long customerId) throws CustomerException{

			try {
				Optional<Customer> optional= customerDao.findById(customerId);
				if(optional.isPresent()) {
					return optional.get();
				}else {
					throw new Exception("Invalid CustomerId");
				}
			}catch(DataAccessException e) {
				//converting SQLException to CustomerException
				throw new CustomerException(e.getMessage());
			}catch(Exception e) {
				//converting SQLException to CustomerException
				throw new CustomerException(e.getMessage());
			}
		}
	/**
     * This method is used to getAll Customer 
     */
	@Override
	public List<Customer> getAllCustomers() throws CustomerException{
			try {
				return customerDao.findAll();
			}catch(DataAccessException e) {
				//converting SQLException to CustomerException
				throw new CustomerException(e.getMessage());
			}catch(Exception e) {
				//converting SQLException to CustomerException
				throw new CustomerException(e.getMessage());
			}
		}

}
