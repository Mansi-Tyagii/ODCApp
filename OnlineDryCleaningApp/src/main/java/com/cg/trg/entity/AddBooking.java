package com.cg.trg.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.cg.trg.Enum.BookingStatus;
import com.cg.trg.Enum.BookingType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"bookingDateAndTime"}, allowGetters=true)
public class AddBooking {
//	@Column(nullable=true, updatable=false)
//	@Temporal(TemporalType.TIMESTAMP)
//	@CreatedDate
//	private Date bookingDateAndTime;
	private BookingType bookingType;
	private Long customerId;
}
