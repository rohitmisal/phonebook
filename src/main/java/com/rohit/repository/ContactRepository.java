package com.rohit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

	
}
