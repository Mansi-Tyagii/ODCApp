package com.cg.trg.entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAddress {
	private String doorNo;
	private String street;
	private String area;
	private String city;
	private String state;
	private Integer pincode;
	private Long customerId;
}
