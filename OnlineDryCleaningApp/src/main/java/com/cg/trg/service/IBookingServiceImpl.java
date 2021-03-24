package com.cg.trg.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.trg.dao.IBookingRepositoryDao;
import com.cg.trg.dao.ICustomerRepositoryDao;
import com.cg.trg.entity.AddBooking;
import com.cg.trg.entity.Booking;
import com.cg.trg.entity.Customer;
import com.cg.trg.exception.BookingException;
/**
 * 
 * @author Mansi
 * This is Booking Service Interface Implementation Class.
 * Performing  Add,Remove,Update,GetAll,GetById,GetByCustomer and Get methods.
 */
@Service
@Transactional
public class IBookingServiceImpl implements  IBookingService {
	@Autowired
	private IBookingRepositoryDao bookingDao;
	
	 @Autowired
     private ICustomerRepositoryDao customerDao;
	 /**
	 * This method is used to Add Booking Using  AddBooking Object
	 */
	@Override
	public Booking addBooking(AddBooking addbooking) throws BookingException{
		Booking book = new Booking();
		Long custId = addbooking.getCustomerId();
		try {	
			//book.setBookingDateAndTime(addbooking.getBookingDateAndTime());
			book.setBookingType(addbooking.getBookingType());
			if(custId != null) {
				Optional<Customer> optional=customerDao.findById(custId);
                if(optional.isPresent())
                {
                    book.setCustomer(optional.get());
                }
			}
			bookingDao.save(book);
			 return book;
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new BookingException(e.getMessage());
		}
	}
/**
 * This method is used to Remove Booking Using  BookingId 
 */
	@Override
	public void removeBooking(Long bookingId) throws BookingException {
		try {
			bookingDao.deleteById(bookingId);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new BookingException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new BookingException(e.getMessage());
		}
	}
	/**
	 * This method is used to Update Booking Using  Booking Object
	 */
	@Override
	public Booking updateBooking(Booking booking) throws BookingException {
		try {
			return bookingDao.save(booking);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new BookingException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new BookingException(e.getMessage());
		}
	}
	/**
	 * This method is used to get Booking Using  BookingId 
	 */
	@Override
	public Booking getBookingbyId(Long bookingId) throws BookingException {
		try {
			Optional<Booking> optional= bookingDao.findById(bookingId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid BookingId");
			}
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new BookingException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new BookingException(e.getMessage());
		}
	}
	/**
	 * This method is used to GetAll Booking 
	 */
	@Override
	public List<Booking> getAllBookings() throws BookingException{
		try {
			return bookingDao.findAll();
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new BookingException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new BookingException(e.getMessage());
		}
	}

	
	/**
	 * This method is used to get Booking Using  Customer 
	 */
	@Override
	public List<Booking> getBookingsByCustomer(Customer customer) throws BookingException{
		try {
			List<Booking> booking= bookingDao.findByCustId(customer);
			if(booking.isEmpty()) {
				
				throw new Exception("Invalid CustomerId");
			}else {
				return  booking;
			}
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new BookingException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new BookingException(e.getMessage());
		}
	}

	

//	@Override
//	public List<Booking> getByBookingDate(LocalDate bookingDate) throws BookingException {
//		try {
//			Optional<Booking> optional= bookingDao.findByBookingDate(bookingDate);
//			if(optional.isPresent()) {
//				return (List<Booking>) optional.get();
//			}else {
//				throw new Exception("Invalid CustomerId");
//			}
//		}catch(DataAccessException e) {
//			//converting SQLException to EmployeeException
//			throw new BookingException(e.getMessage());
//		}catch(Exception e) {
//			//converting SQLException to EmployeeException
//			throw new BookingException(e.getMessage());
//		}
//	}
}
