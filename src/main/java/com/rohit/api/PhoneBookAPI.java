package com.rohit.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.model.Contact;
import com.rohit.service.ContactService;

@RestController
@CrossOrigin
public class PhoneBookAPI {
	
	@Autowired
	ContactService contactService;

	//POST => http://localhost:8080/contact
	@PostMapping("/contact")
	public String addContactDetails(@RequestBody  Contact contact) {
		String msg = contactService.addContactDetails(contact);
		return msg;
	}

	//GET => http://localhost:8080/contacts
	@GetMapping("/contacts")
	public List<Contact> getAllContactDetails() {
		List<Contact> listContacts = contactService.getAllContacts();
		return listContacts;
	}

	//PUT => http://localhost:8080/contact/
	@PutMapping("/contact")
	public String updateContactDetils(@RequestBody Contact contact) {
		String msg = contactService.updateContactDetails(contact);
		return msg;
	}

	//DELETE => http://localhost:8080/contact/101
	@DeleteMapping("/contact/{contactId}")
	public String deleteContact(@PathVariable Integer contactId) {
		String msg = contactService.deleteContact(contactId);
		return msg;

	}

	//GET => http://localhost:8080/contact/101
	@GetMapping("/contact/{contactId}")
	public Contact getContactById(@PathVariable Integer contactId) {
		Contact contact = contactService.getContactById(contactId);
		return contact;
	}

}
