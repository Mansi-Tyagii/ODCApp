package com.cg.trg.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cg.trg.dao.IBookingRepositoryDao;
import com.cg.trg.dao.ICustomerRepositoryDao;
import com.cg.trg.dao.IPaymentRepositoryDao;
import com.cg.trg.entity.AddPayment;
import com.cg.trg.entity.Booking;
import com.cg.trg.entity.Customer;
import com.cg.trg.entity.Payment;
import com.cg.trg.exception.AddressException;
import com.cg.trg.exception.PaymentException;
/**
 * 
 * @author Shruti
 * This is Payment Service Interface Implementation Class.
 * Performing  Add,Remove,Update, Get and GetAll methods.
 */
@Service
@Transactional
public class IPaymentServiceImpl implements IPaymentService {

	@Autowired 
	private IPaymentRepositoryDao iPaymentRepositoryDao;
	
	  @Autowired
	     private ICustomerRepositoryDao customerDao;
	  
	  @Autowired
		private IBookingRepositoryDao bookingDao;
	  /**
	     * This method is used to Add Payment Using AddPayment Object
	     */
	@Override
	public Payment addPayment(AddPayment addPayment) throws PaymentException {
		 Payment pay=new Payment();
	        Long custId=addPayment.getCustomerId();
	        Long bookId=addPayment.getBookingId();
	        try
	        {
	        	pay.setAmount(addPayment.getAmount());
	        	pay.setBillingdate(addPayment.getBillingdate());
	        	pay.setPaymentMethod(addPayment.getPaymentMethod());
	        	pay.setPaymentType(addPayment.getPaymentMethod());
	        	
	        	
	           
	            
	            if(custId != null)
	            {
	                Optional<Customer> optional=customerDao.findById(custId);
	                if(optional.isPresent())
	                {
	                    pay.setCustomer(optional.get());
	                }
	            }
	            
	            if(bookId != null)
	            {
	                Optional<Booking> optional=bookingDao.findById(bookId);
	                if(optional.isPresent())
	                {
	                    pay.setBooking(optional.get());
	                }
	            }

	 
	            iPaymentRepositoryDao.save(pay);
	            return pay;
	        }
	        
	        catch(Exception e)
	        {
	            throw new PaymentException(e.getMessage());
	        }
	}
	/**
     * This method is used to Remove Payment Using AddPaymentId
     */
	@Override
	public void removePayment(Long paymentId) throws PaymentException{
		try {
			iPaymentRepositoryDao.deleteById(paymentId);
		}catch(DataAccessException e) {
			//converting SQLException to PaymentException
			throw new PaymentException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to PaymentException
			throw new PaymentException(e.getMessage());
		}
	}
	/**
     * This method is used to Update Payment Using Payment Object
     */
	@Override
	public Payment updatePayment( Payment payment) throws PaymentException {
		try {
			return iPaymentRepositoryDao.save(payment);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new PaymentException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new PaymentException(e.getMessage());
		}
		
	}
	/**
     * This method is used to Get Payment Using PaymentId Object
     */
	@Override
	public Payment getPaymentDetails(Long paymentId) throws PaymentException {
		try {
			Optional<Payment> optional= iPaymentRepositoryDao.findById(paymentId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid Empno");
			}
		}catch(DataAccessException e) {
			//converting SQLException to PaymentException
			throw new PaymentException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to PaymentException
			throw new PaymentException(e.getMessage());
		}
	}
	/**
     * This method is used to GetAll Payment
     */
	@Override
	public List<Payment> getAllPaymentDetails() throws PaymentException{
		try {
			return iPaymentRepositoryDao.findAll();
		}catch(DataAccessException e) {
			//converting SQLException to PaymentException
			throw new PaymentException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to PaymentException
			throw new PaymentException(e.getMessage());
		}
	}

}
