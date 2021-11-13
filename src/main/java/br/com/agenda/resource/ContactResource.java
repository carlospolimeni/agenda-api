package br.com.agenda.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.constants.Constants;
import br.com.agenda.domain.request.ContactRequest;
import br.com.agenda.domain.response.ContactResponse;
import br.com.agenda.service.ContactService;

@RestController
@RequestMapping(path = Constants.PATH_CONTACTS)
public class ContactResource {

	@Autowired
	private ContactService contactService;

	@PostMapping
	public ResponseEntity<ContactResponse> create(@RequestBody ContactRequest request) {
		return contactService.create(request);
	}
}