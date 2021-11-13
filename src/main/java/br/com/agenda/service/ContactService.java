package br.com.agenda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.agenda.domain.Contact;
import br.com.agenda.domain.request.ContactRequest;
import br.com.agenda.domain.response.ContactResponse;
import br.com.agenda.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	public ResponseEntity<ContactResponse> create(ContactRequest request) {

		Optional<Contact> contact = contactRepository.findByName(request.getName());
		
		if(contact.isPresent()) {
			return ResponseEntity.badRequest().build();
		} else {
			Contact newContact = new Contact();
			newContact.setName(request.getName());
			newContact.setStatus(Boolean.TRUE);
			
			Contact response = contactRepository.save(newContact);
			
			return ResponseEntity.ok(new ContactResponse(response.getId()));
		}
	}
}