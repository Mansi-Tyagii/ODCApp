package com.cg.trg.entity;



import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * 
 * @author Pravartika
 *This is Customer Entity Class.
 */
@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "customer_odc")

public class Customer {
	@Id
	@Column(name="customerId")
	private Long customerId;
	
	@Column(name="customerName")
	private String customerName;
	@Column(name="emailId")
	private String emailId;
	@Column(name="contactNo")
	private Long contactNo;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="userId")
	private User user;
	
	


	//address customer
	@OneToMany(mappedBy = "customer")
	@JsonIgnore
	private List<Address> addressSet;
	
	
	//payment customer
	@OneToMany(mappedBy="customer")
	@JsonIgnore
	private List<Payment> paymentSet;
	
	
	//booking customer
	@OneToMany(mappedBy="customer")
	@JsonIgnore
	private List<Booking> bookingSet;
	
	
	//Feedback Customer
	@OneToMany(mappedBy="customer")
	@JsonIgnore
	private List<Feedback> feedbackSet;
	
	
	public Customer(Long customerId, String customerName, String emailId, Long contactNo, com.cg.trg.entity.User user) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.emailId=emailId;
		this.contactNo= contactNo;
		this.user = user;
	}
	

//	public Customer(long customerId) {
//		super();
//		this.customerId = customerId;
//	}
	
	
}
