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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Feedback")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Feedback {
	
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long feedbackNumber;
		private Integer bookingId;

		@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
		@JoinColumn(name = "customerId",nullable = false)
		@JsonIgnore
		private Customer customer;
		
		private String custEmail;
		private Integer rating;
		private String description;
		
		
}
	