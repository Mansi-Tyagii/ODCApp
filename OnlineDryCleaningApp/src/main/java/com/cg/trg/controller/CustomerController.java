package com.cg.trg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.trg.entity.AddAddress;
import com.cg.trg.entity.AddBooking;
import com.cg.trg.entity.AddBookingItem;
import com.cg.trg.entity.AddPayment;
import com.cg.trg.entity.Address;
import com.cg.trg.entity.Booking;
import com.cg.trg.entity.BookingItem;
import com.cg.trg.entity.Customer;
import com.cg.trg.entity.Payment;
import com.cg.trg.exception.AddressException;
import com.cg.trg.exception.BookingException;
import com.cg.trg.exception.BookingItemException;
import com.cg.trg.exception.CustomerException;
import com.cg.trg.exception.PaymentException;
import com.cg.trg.service.AddressService;
import com.cg.trg.service.CustomerService;
import com.cg.trg.service.IBookingItemService;
import com.cg.trg.service.IBookingService;
import com.cg.trg.service.IPaymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 
 * This is an Customer Controller
 *
 */
@Api
@RestController
@RequestMapping("/api/cust")
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private IBookingService bookingService;
	
	@Autowired
	private IBookingItemService bookingItemService;
	
	@Autowired
	private IPaymentService iPaymentService;
	
	
	/**
	 * 
	 * @param customer
	 * Add customer
	 * @return
	 */
	@ApiOperation(value = "Add customer",
			response = Customer.class,
			consumes = "Customer Object",
			tags = "Post Customer record",
			httpMethod = "POST")
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		try {
			Customer cust= customerService.addCustomer(customer);
			return new ResponseEntity<>(cust, HttpStatus.OK);
		}catch(CustomerException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param addAddress
	 * Add Address
	 * @return
	 */
	@ApiOperation(value = "Add Address",
			response = Customer.class,
			consumes = "AddAddress Object",
			tags="Post Address record",
			httpMethod = "POST")
	@PostMapping("/address")
	public ResponseEntity<Address> addAddress(@RequestBody AddAddress addAddress) {
		try {
			Address add= addressService.addAddress(addAddress);
			return new ResponseEntity<>(add, HttpStatus.OK);
		}catch(AddressException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param customerId
	 * Delete customer
	 * @return
	 */
	@ApiOperation(value = "Delete customer",
			response = String.class,
			consumes = "customerId",
			tags = "Delete customer record",
			httpMethod = "DELETE")
	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<String> removeCustomer(@PathVariable Long customerId) {
		try {
			customerService.removeCustomer(customerId);
			return new ResponseEntity<>("Customer removed", HttpStatus.OK);
		}catch(CustomerException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param customer
	 * Update customer
	 * @return
	 */
	@ApiOperation(value = "Update customer",
			response = Customer.class,
			consumes = "Customer Object",
			tags = "Update customer record",
			httpMethod = "PUT")
	@PutMapping("/customers")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		try {
			Customer cust= customerService.updateCustomer(customer);
			return new ResponseEntity<>(cust, HttpStatus.OK);
		}catch(CustomerException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param customerId
	 * Get customer by Id
	 * @return
	 */
	@ApiOperation(value = "Get customer by Id",
			response = Customer.class,
			tags = "get-customer",
			consumes = "customerId",
			httpMethod = "GET")
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Long customerId){
		try {
			Customer cust= customerService.getCustomer(customerId);
			return new ResponseEntity<>(cust, HttpStatus.OK);
		}catch(CustomerException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
}
	/**
	 * Get all customers
	 * @return
	 */
	@ApiOperation(value = "Get all customers",
			response = Customer.class,
			tags = "get-all-customer",			
			httpMethod = "GET")
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		try {
			List<Customer> customerList = customerService.getAllCustomers();
			return new ResponseEntity<>(customerList, HttpStatus.OK);
		}catch(CustomerException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param addbooking
	 * add booking
	 * @return
	 */
	@ApiOperation(value = "add booking",
			response = Booking.class,
			tags = "post-booking",
			consumes = "AddBooking Object",
			httpMethod = "POST")
	@PostMapping("/booking")
	public ResponseEntity<Booking> addBooking(@RequestBody AddBooking addbooking) {
		try {
			Booking bkg= bookingService.addBooking(addbooking);
			return new ResponseEntity<>(bkg, HttpStatus.OK);
		}catch(BookingException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param bookingId
	 * remove booking
	 * @return
	 */
	@ApiOperation(value = "remove booking",
			response = String.class,
			tags = "remove booking",
			consumes = "bookingId",
			httpMethod = "DELETE")
	@DeleteMapping("/booking/{bookingId}")
	public ResponseEntity<String> removeBooking(@PathVariable Long bookingId) {
		try {
			bookingService.removeBooking(bookingId);
			return new ResponseEntity<>("Booking removed", HttpStatus.OK);
		}catch(BookingException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param booking
	 * update booking
	 * @return
	 */
	@ApiOperation(value = "update booking",
			response = Booking.class,
			tags = "update booking",
			consumes = "booking",
			httpMethod = "PUT")
	@PutMapping("/booking")
	public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking) {
		try {
			Booking bkg= bookingService.updateBooking(booking);
			return new ResponseEntity<>(bkg, HttpStatus.OK);
		}catch(BookingException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	/**
	 * 
	 * @param bookingId
	 * Get booking by Id
	 * @return
	 */
	@ApiOperation(value = "Get booking by Id",
			response = Booking.class,
			tags = "get-booking-byID",
			consumes = "bookingId",
			httpMethod = "GET")
	@GetMapping("/booking/{bookingId}")
	public ResponseEntity<Booking> getBookingbyId(@PathVariable Long bookingId){
		try {
			Booking bkg = bookingService.getBookingbyId(bookingId);
			return new ResponseEntity<>(bkg, HttpStatus.OK);
		}catch(BookingException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}
	
	/**
	 * 
	 * @param customer
	 * Get booking by CustomerId
	 * @return
	 */
	@ApiOperation(value = "Get booking by CustomerId",
			response = Booking.class,
			tags = "get booking",
			consumes = "Customer Object",
			httpMethod = "GET")
	@GetMapping("/bookingcu/{customer}")
	public ResponseEntity<List<Booking>>getBookingsByCustomer(@PathVariable Customer customer){
		try {
			List<Booking> bkg= bookingService.getBookingsByCustomer(customer);
			return new ResponseEntity<>(bkg, HttpStatus.OK);
		}catch(BookingException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}

	
	/**
	 * 
	 * @param addBookingItem
	 * Add Booking item
	 * @return
	 */
	@ApiOperation(value = "Add Booking item",
			response = BookingItem.class,
			consumes = "AddBookingItem Object",
			tags = "Post Booking Item record",
			httpMethod = "POST")
	@PostMapping("/bookingitem")
	public ResponseEntity<BookingItem> addBookingItem(@RequestBody AddBookingItem addBookingItem) {
		try {
			BookingItem bitem= bookingItemService.addBookingItem(addBookingItem);
			return new ResponseEntity<>(bitem, HttpStatus.OK);
		}catch(BookingItemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	/**
	 * 
	 * @param bookingItemId
	 * Delete Booking Item
	 * @return
	 */
	@ApiOperation(value = "Delete Booking Item",
			response = String.class,
			consumes = "customerId",
			tags = "Delete Booking item record",
			httpMethod = "DELETE")
	@DeleteMapping("/bookingitem/{bookingItemId}")
	public ResponseEntity<String> removeBookingItem(@PathVariable Long bookingItemId) {
		try {
			bookingItemService.removeBookingItem(bookingItemId);
			return new ResponseEntity<>("Booking Item removed", HttpStatus.OK);
		}catch(BookingItemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	/**
	 * 
	 * @param item
	 * Update Booking item
	 * @return
	 */
	@ApiOperation(value = "Update Booking item",
			response = BookingItem.class,
			consumes = "BookingItem",
			tags = "Update Booking item record",
			httpMethod = "PUT")
	@PutMapping("/bookingitem1")
	public ResponseEntity<BookingItem> updateBookingItem(@RequestBody BookingItem item) {
		try {
			BookingItem bitem= bookingItemService.updateBookingItem(item);
			return new ResponseEntity<>(bitem, HttpStatus.OK);
		}catch(BookingItemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	/**
	 * 
	 * @param bookingItemId
	 * Get Booking item by Id
	 * @return
	 */
	@ApiOperation(value = "Get Booking item by Id",
			response = BookingItem.class,
			tags = "get-Booking Item",
			consumes = "bookingItemId",
			httpMethod = "GET")
	@GetMapping("/bookingitem/{bookingItemId}")
	public ResponseEntity<BookingItem> getBookingItem(@PathVariable Long bookingItemId){
		try {
			BookingItem bitem = bookingItemService.getBookingItem(bookingItemId);
			return new ResponseEntity<>(bitem, HttpStatus.OK);
		}catch(BookingItemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}
	
	
	
	
	/**
	 * 
	 * @param paymentId
	 * Get payment details
	 * @return
	 */
	@ApiOperation(value = "Get payment details",
			response = Payment.class,
			tags = "get-payment-details",
			consumes = "paymentId",
			httpMethod = "GET")
	@GetMapping("/payments/{paymentId}")
	public ResponseEntity<Payment> getPaymentDetails(@PathVariable Long paymentId){
		try {
			Payment payment = iPaymentService.getPaymentDetails(paymentId);
			return new ResponseEntity<>(payment, HttpStatus.OK);
		}catch(PaymentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}

	/**
	 * Get all payment details
	 * @return
	 */
	@ApiOperation(value = "Get all payment details",
			response = Payment.class,
			tags = "get-all-payment-details",			
			httpMethod = "GET")
	@GetMapping("/payments")
	public ResponseEntity<List<Payment>> getAllPaymentDetails(){
		try {
			List<Payment> paymentList = iPaymentService.getAllPaymentDetails();
			return new ResponseEntity<>(paymentList, HttpStatus.OK);
		}catch(PaymentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param addPayment
	 * Add payment
	 * @return
	 */
	@ApiOperation(value = "Add payment",
			response = Payment.class,
			consumes = "AddPayment Object",
			tags = "Post payment record",
			httpMethod = "POST")
	@PostMapping("/payments")
	public ResponseEntity<Payment> addPayment(@RequestBody AddPayment addPayment) {
		try {
			Payment pay= iPaymentService.addPayment(addPayment);
			return new ResponseEntity<>(pay, HttpStatus.OK);
		}catch(PaymentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	/**
	 * 
	 * @param payment
	 * Update payment
	 * @return
	 */
	@ApiOperation(value = "Update payment",
			response = Payment.class,
			consumes = "Payment Object",
			tags = "Update payment record",
			httpMethod = "PUT")
	@PutMapping("payments")
	public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment) {
		try {
			Payment pay= iPaymentService.updatePayment(payment);
			return new ResponseEntity<>(pay, HttpStatus.OK);
		}catch(PaymentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	/**
	 * 
	 * @param paymentId
	 * Delete payment
	 * @return
	 */
	@ApiOperation(value = "Delete payment",
			response = String.class,
			consumes = "paymentId",
			tags = "Delete payment record",
			httpMethod = "DELETE")
	@DeleteMapping("/payments/{paymentId}")
	public ResponseEntity<String> removePayment(@PathVariable Long paymentId) {
		try {
			iPaymentService.removePayment(paymentId);
			return new ResponseEntity<>("Payment deleted", HttpStatus.OK);
		}catch(PaymentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

    }


	

