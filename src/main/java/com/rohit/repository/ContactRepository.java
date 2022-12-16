package com.rohit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

	
	public List<Contact> findByisActive(String isActive);
}
