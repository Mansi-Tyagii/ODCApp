package com.cg.trg.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cg.trg.Enum.ServiceType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Shivam
 *This is ItemCharges Entity Class.
 */
@Entity
@Table(name = "item_charges_odc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemCharges {
	
	public ItemCharges(Double chargesPerUnit, String itemCategory, ServiceType serviceType) {
		super();
		this.chargesPerUnit = chargesPerUnit;
		this.itemCategory = itemCategory;
		this.serviceType = serviceType;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemChargesId;
	private Double chargesPerUnit;
	private String itemCategory;
	private ServiceType  serviceType;
	
	@OneToMany(mappedBy="itemCharges")
	@JsonIgnore
	private List<BookingItem> bookingItemSet;

}
