package com.cg.trg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cg.trg.Enum.ItemCategory;
import com.cg.trg.Enum.ServiceType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Shivam
 * This is BookingItem Entity Class.
 *
 */
@Entity
@Table(name = "booking_item_odc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingItemId;
	private Integer quantity; 
	private String description;
	private ServiceType serviceType;
	private ItemCategory category;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "bookingId")
	@JsonIgnore
	private Booking booking;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "itemChargesId")
	@JsonIgnore
	private ItemCharges itemCharges;

	public BookingItem(Integer quantity, String description, ServiceType serviceType, ItemCategory category,
			Booking booking, ItemCharges itemCharges) {
		super();
		this.quantity = quantity;
		this.description = description;
		this.serviceType = serviceType;
		this.category = category;
		this.booking = booking;
		this.itemCharges = itemCharges;
	}
	
	


}
