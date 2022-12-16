package com.rohit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.model.Contact;
import com.rohit.repository.ContactRepository;
import com.rohit.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepository;

	@Override
	public String addContactDetails(Contact contact) {
		Contact c = contactRepository.save(contact);
		if (c.getContactId() != null) {
			return "Contact Saved successfully";
		} else {
			return "Something went wrong";
		}
	}

	@Override
	public List<Contact> getAllContacts() {

		return contactRepository.findByisActive("Y");
	}

	@Override
	public String updateContactDetails(Contact contact) {

		Integer id = contact.getContactId();
		if (contactRepository.existsById(id)) {
			contactRepository.save(contact);
			return "Contact update Sccessfully";
		} else {
			return "contact with given id does not exist";
		}
	}

	@Override
	public String deleteContact(Integer contactId) {

		Optional<Contact> contact = contactRepository.findById(contactId);
		
			if(contactRepository.existsById(contactId)){
			Contact c= contact.get();
				c.setIsActive("N");
				contactRepository.save(c);
				return "contact deleted Succcessfully";

			}else {
				return "contact with given id does not exist";
			}
		
			/*
			 * if (contactRepository.existsById(contactId)) {
			 * 
			 * contactRepository.deleteById(contactId); return
			 * "contact deleted Succcessfully"; } else { return
			 * "contact with given id does not exist"; }
			 */
	}

	@Override
	public Contact getContactById(Integer contactId) {

		Optional<Contact> contact = contactRepository.findById(contactId);
		if (contact.isPresent()) {
			return contact.get();
		}
		return null;
	}

}
