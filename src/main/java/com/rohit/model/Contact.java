package com.rohit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="CONTACT_DETAILS")
public class Contact {

	@Id
	@GeneratedValue
	private Integer contactId;
	
	private String contactName;
	private String contactEmail;
	private Long contactNumber;
	private String isActive;
	
}
