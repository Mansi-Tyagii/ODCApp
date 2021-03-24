package com.cg.trg.entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddPayment {

	private Double amount;
	private LocalDate billingdate;
	private String paymentMethod;
	private String paymentType;
	private Long customerId;
	private Long bookingId;
}
