package com.cg.trg.service;


import java.time.LocalDate;
import java.util.List;

import com.cg.trg.entity.AddBooking;
import com.cg.trg.entity.Booking;
import com.cg.trg.entity.Customer;
import com.cg.trg.exception.BookingException;
/**
 * 
 * @author Mansi
 * This is Booking Service Interface Class.
 * Contains Add,Remove,Update,GetAll,GetById,GetByCustomer and Get methods.
 * 
 */
public interface IBookingService {
	public Booking addBooking(AddBooking addbooking) throws BookingException;
	public void removeBooking(Long bookingId) throws BookingException;
	public Booking updateBooking(Booking booking) throws BookingException;
	public Booking getBookingbyId(Long bookingId) throws BookingException;
	public List<Booking> getAllBookings()throws BookingException;
	public List<Booking> getBookingsByCustomer(Customer customer) throws BookingException;
	//public List<Booking> getByBookingDate(LocalDate bookingDate) throws BookingException;
}
