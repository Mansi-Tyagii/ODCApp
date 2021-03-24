package com.cg.trg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.trg.dao.IBookingItemRepositoryDao;
import com.cg.trg.dao.IBookingRepositoryDao;
import com.cg.trg.dao.IItemChargesRepositoryDao;
import com.cg.trg.entity.AddBookingItem;
import com.cg.trg.entity.Booking;
import com.cg.trg.entity.BookingItem;
import com.cg.trg.entity.ItemCharges;
import com.cg.trg.exception.BookingItemException;



/**
 * 
 * @author Shivam
 * This is BookingItem Service Interface Implementation Class.
 * Performing  Add,Remove,Update and Get methods.
 */
@Service
@Transactional
public class IBookingItemServiceImpl implements IBookingItemService  {

	@Autowired
	private IBookingItemRepositoryDao iBookingItemRepositoryDao;
	
	@Autowired
	private IBookingRepositoryDao bookingDao;
	
	@Autowired
	private IItemChargesRepositoryDao iItemChargesRepositoryDao;
	
	/**
     * This method is used to Add BookingItem Using  AddBookingItem Object
     */
	@Override
	public BookingItem addBookingItem(AddBookingItem addbookingItem) throws BookingItemException {
		BookingItem bookItem=new BookingItem();
	        Long bookId=addbookingItem.getBookingId();
	       Long itemCharges=addbookingItem.getItemChargesId();
	        try
	        {
	        	bookItem.setCategory(addbookingItem.getCategory());
	        	bookItem.setQuantity(addbookingItem.getQuantity());
	        	bookItem.setDescription(addbookingItem.getDescription());
	        	bookItem.setServiceType(addbookingItem.getServiceType());
	        	
	        	
	           
	            
	            if(bookId != null)
	            {
	                Optional<Booking> optional=bookingDao.findById(bookId);
	                if(optional.isPresent())
	                {
	                	bookItem.setBooking(optional.get());
	                }
	            }
	            
	            if(itemCharges != null)
	            {
	                Optional<ItemCharges> optional=iItemChargesRepositoryDao.findById(itemCharges);
	                if(optional.isPresent())
	                {
	                	bookItem.setItemCharges(optional.get());
	                }
	            }

	 
	            iBookingItemRepositoryDao.save(bookItem);
	            return bookItem;
	        }
	        
	        catch(Exception e)
	        {
	            throw new BookingItemException(e.getMessage());
	        }
	}
	/**
     * This method is used to Remove BookingItem Using  AddBookingItemId
     */
	@Override
	public void removeBookingItem(Long bookingItemId) throws BookingItemException {
		try {
			iBookingItemRepositoryDao.deleteById(bookingItemId);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new BookingItemException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new BookingItemException(e.getMessage());
		}
	}
	/**
     * This method is used to Update BookingItem Using  BookingItem Object
     */
	@Override
	public BookingItem updateBookingItem(BookingItem item)throws BookingItemException {
		try {
			return iBookingItemRepositoryDao.save(item);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new BookingItemException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new BookingItemException(e.getMessage());
		}
	}
	/**
     * This method is used to Get BookingItem Using  BookingItemId
     */
	@Override
	public BookingItem getBookingItem(Long bookingItemId) throws BookingItemException{
		try {
			Optional<BookingItem> optional= iBookingItemRepositoryDao.findById(bookingItemId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid Item ID");
			}
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new BookingItemException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new BookingItemException(e.getMessage());
		}
	}

//	@Override
//	public List<BookingItem> getBookingItemsByCustomer(Long bookingItemId) throws BookingItemException{
//		try {
//			Optional<BookingItem> optional= iBookingItemRepositoryDao.findById(bookingItemId);
//			if(optional.isPresent()) {
//				return (List<BookingItem>) optional.get();
//			}else {
//				throw new Exception("Invalid Booking ID");
//			}
//		}catch(DataAccessException e) {
//			//converting SQLException to EmployeeException
//			throw new BookingItemException(e.getMessage());
//		}catch(Exception e) {
//			//converting SQLException to EmployeeException
//			throw new BookingItemException(e.getMessage());
//		}
//	}

	
	

}
