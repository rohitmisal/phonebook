package com.rohit.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.model.Contact;
import com.rohit.service.ContactService;

@RestController
public class PhoneBookAPI {

	@Autowired
	ContactService contactService;

	@PostMapping("/addcontact")
	public String addContactDetaisl(Contact contact) {
		String msg = contactService.addContactDetails(contact);
		return msg;
	}

	@GetMapping("/getallcontacts")
	public List<Contact> getAllContactDetails() {
		List<Contact> listContacts = contactService.getAllContacts();
		return listContacts;
	}

	@PostMapping("/updateContact")
	public String updateContactDetils(Contact contact) {
		String msg = contactService.updateContactDetails(contact);
		return msg;
	}

	@GetMapping("/deletContact")
	public String deleteContace(Integer contactId) {
		String msg = contactService.deleteContact(contactId);
		return msg;

	}

	@GetMapping("/getcontactbyid")
	public Contact getContactById(Integer contactId) {
		Contact contact = contactService.getContactById(contactId);
		return contact;
	}

}
