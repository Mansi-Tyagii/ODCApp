package com.cg.trg.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.cg.trg.Enum.BookingStatus;
import com.cg.trg.Enum.BookingType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Mansi
 * This is Booking Entity Class.
 *
 */
@Entity
@Table(name = "booking_odc")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"bookingDateAndTime"}, allowGetters=true)
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingId;
//	@Column(nullable=false, updatable=false)
//	@Temporal(TemporalType.TIMESTAMP)
//	@CreatedDate
//	private Date bookingDateAndTime;
	//private Customer customerDetails;
	private BookingStatus bookingStatus;
	private BookingType bookingType;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId")
	@JsonIgnore
	private Customer customer;
	
	@OneToMany(mappedBy="booking")
	@JsonIgnore
	private List<BookingItem> bookingItemSet;

	public Booking( BookingType bookingType, Customer customer) {
		super();
		//this.bookingDateAndTime = bookingDateAndTime;
		this.bookingType = bookingType;
		this.customer = customer;
	}

	
}
