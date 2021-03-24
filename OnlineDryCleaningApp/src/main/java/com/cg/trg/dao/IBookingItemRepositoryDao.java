package com.cg.trg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 
 * This is an Booking Item Repository Interface which Extends JpaRepository
 *
 */
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.trg.entity.BookingItem;
@Repository
public interface IBookingItemRepositoryDao extends JpaRepository<BookingItem,Long> {

	
}
