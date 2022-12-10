package com.rohit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rohit.model.Contact;

@Service
public interface ContactService {

	public String addContactDetails(Contact contact);
	public List<Contact> getAllContacts();
	public Contact getContactById(Integer contactId);
	public String updateContactDetails(Contact contact);
	public String deleteContact(Integer contactId);
	
}
