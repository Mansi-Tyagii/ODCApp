package com.cg.trg.entity;

import javax.persistence.Column;

/**
 * 
 * @author Mrunal
 * This is User Entity Class.
 *
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cg.trg.entity.Admin;
import com.cg.trg.entity.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="user_odc")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="userId")
	public long userId;
	public String name;
	public String emailId;
	public long contactNo;
	private String password;
	public String userType;
	@OneToOne(mappedBy= "user")
	@JsonIgnore
	private Admin admin;
	
	@OneToOne(mappedBy="user")
	@JsonIgnore
	private Customer customer;
	
}
