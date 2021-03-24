package com.cg.trg.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Mrunal
 * This is Admin Entity Class.
 *
 */
@Entity
@Table(name="admin_odc")
@NoArgsConstructor
//@AllArgsConstructor
@Data
public class Admin {
	@Id
	@Column(name="adminId")
	private Long adminId;
	
	@Column(name="adminName")
	private String adminName;
	@Column(name="emailId")
	private String emailId;
	@Column(name="contactNo")
	private Long contactNo;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="userId")
	private User user;
	
	public Admin(Long adminId, String adminName, String emailId, Long contactNo, com.cg.trg.entity.User user) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.emailId=emailId;
		this.contactNo= contactNo;
		this.user = user;
	}

}
