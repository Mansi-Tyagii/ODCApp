package com.cg.trg.entity;

import com.cg.trg.Enum.BookingType;
import com.cg.trg.Enum.ItemCategory;
import com.cg.trg.Enum.ServiceType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddBookingItem {

	private Integer quantity; 
	private String description;
	private ServiceType serviceType;
	private ItemCategory category;
	private Long itemChargesId;
	private Long bookingId;
}
