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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api("This is contact API")
public class PhoneBookAPI {

	@Autowired
	ContactService contactService;

	@ApiOperation("THis is used to Add contact")
	@PostMapping("/contact")
	public String addContactDetails(@RequestBody Contact contact) {
		contact.setIsActive("Y");
		String msg = contactService.addContactDetails(contact);
		return msg;
	}

	@ApiOperation("THis is used to get all contacts")
	@GetMapping("/contacts")
	public List<Contact> getAllContactDetails() {
		List<Contact> listContacts = contactService.getAllContacts();
		return listContacts;
	}

	@ApiOperation("THis is used to update contact")
	@PutMapping("/contact")
	public String updateContactDetils(@RequestBody Contact contact) {
		String msg = contactService.updateContactDetails(contact);
		return msg;
	}

	@ApiOperation("THis is used to delte  contact by Id")
	@DeleteMapping("/contact/{contactId}")
	public String deleteContact(@PathVariable Integer contactId) {
		String msg = contactService.deleteContact(contactId);
		return msg;

	}

	@ApiOperation("THis is used to get contact by ID")
	@GetMapping("/contact/{contactId}")
	public Contact getContactById(@PathVariable Integer contactId) {
		Contact contact = contactService.getContactById(contactId);
		return contact;
	}

}
