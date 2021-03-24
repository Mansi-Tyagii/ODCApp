package com.cg.trg.controller;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.cg.trg.Enum.BookingType;
import com.cg.trg.entity.Booking;
import com.cg.trg.entity.Customer;
import com.cg.trg.exception.BookingException;
import com.cg.trg.exception.CustomerException;
import com.cg.trg.service.AddressService;
import com.cg.trg.service.CustomerService;
import com.cg.trg.service.IBookingItemService;
import com.cg.trg.service.IBookingService;
import com.cg.trg.service.IPaymentService;



public class CustomertControllerTest {

	@Mock
	CustomerService customerService;
	
	@Mock
	AddressService addressService;
    
    @Mock
    IBookingService bookingService;
    
    @Mock
    IBookingItemService bookingItemService;

     @Mock
    IPaymentService iPaymentService;
    
	@Test
	void testgetCustomer() throws CustomerException  {
		
		Customer customer=new Customer();
		
		Customer customer1=customerService.getCustomer(1L);
		
		verify(customerService,times(1)).getCustomer(1L);
		
	}

	@Test
	void testgetBookingbyId() throws BookingException {

		Booking booking = new Booking();

		Booking booking1  =bookingService.getBookingbyId(1L);
		verify(bookingService, times(1)).getBookingbyId(1L);
	}

    @Test
	void testAddCustomer() throws CustomerException  {
		Customer cust = new Customer();
		
		Customer cust1=customerService.addCustomer(cust);

		verify(customerService, times(1)).addCustomer(cust);
	}
    
    @Test
	void testUpdateCustomer() throws CustomerException
	{
    	Customer customer=new Customer();
    	
    	customerService.updateCustomer(customer);
    	
		
    	customer.setCustomerName("Abc");
    	
    	customer.setEmailId("Abc@gmail.com");
		
		customerService.updateCustomer(customer);
		
		verify(customerService, times(1)).addCustomer(customer);
		
		verify(customerService, times(1)).updateCustomer(customer);
	
    	
    	
	}

    

    @Test
	void testUpdateBooking() throws BookingException
	{
    	Booking booking=new Booking();
    	
    	bookingService.updateBooking(booking);
    	
		
    
    	
    	booking.setBookingType(BookingType.PICKUP);
		
		bookingService.updateBooking(booking);

		verify(bookingService, times(1)).updateBooking(booking);
		
	
    	
    	
	}
    
    
    
    
    
}