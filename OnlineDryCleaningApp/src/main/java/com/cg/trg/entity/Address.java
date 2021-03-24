package com.cg.trg.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Pravartika
 * This is Address Entity Class.
 * 
 * 
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "address_odc")
public class Address implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long addressId;
	private String doorNo;
	private String street;
	private String area;
	private String city;
	private String state;
	private Integer pincode;
	
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId",nullable = false)
	@JsonIgnore
	private Customer customer;


	public Address(String doorNo, String street, String area, String city, String state, Integer pincode, Customer customer) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.customer=customer;
		
	}


	
	
	
	
}
