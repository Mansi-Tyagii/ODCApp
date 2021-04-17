package com.cg.trg.service;

import java.util.List;

import com.cg.trg.entity.AddBookingItem;
import com.cg.trg.entity.BookingItem;
import com.cg.trg.exception.BookingItemException;


/**
 * 
 * @author Shivam
 * This is BookingItem Service Interface Class.
 * Contains Add,Remove,Update and Get methods.
 */
public interface IBookingItemService {
	public BookingItem addBookingItem(AddBookingItem addbookingItem)throws BookingItemException;
	public void removeBookingItem(Long bookingItemId)throws BookingItemException;
	public BookingItem updateBookingItem( BookingItem item)throws BookingItemException;
	public BookingItem getBookingItem(Long bookingItemId)throws BookingItemException;
	//public List<BookingItem> getBookingItemsByCustomer(Long bookingItemId)throws BookingItemException;
	public List<BookingItem> getAllBookingItems() throws BookingItemException;
}
