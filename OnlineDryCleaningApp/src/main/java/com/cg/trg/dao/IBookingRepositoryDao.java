package com.cg.trg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.trg.entity.Booking;
import com.cg.trg.entity.Customer;

/**
 * 
 * This is an Booking Repository Interface which Extends JpaRepository
 *
 */
@Repository
public interface IBookingRepositoryDao extends JpaRepository<Booking,Long> {
	
//	@Query("select bodc from Booking  bodc where bodc.bookingDate=?1")
//	Optional<Booking> findByBookingDate(LocalDate bookingDate);
	
	@Query("Select b FROM Booking b WHERE b.customer = ?1")
	List<Booking> findByCustId(Customer customer);
}
