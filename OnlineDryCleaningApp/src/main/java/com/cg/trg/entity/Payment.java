package com.cg.trg.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Shurti
 *This is Payment Entity Class.
 */
@Entity
@Table(name = "payment_odc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentId;
	private Double amount;
	private LocalDate billingdate;

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId",nullable = false)
	@JsonIgnore
	private Customer customer;

	private String paymentMethod;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "booking_id",nullable = false)
	@JsonIgnore
	private Booking booking;

	private String paymentType;
	//private String paymentStatus;


}
