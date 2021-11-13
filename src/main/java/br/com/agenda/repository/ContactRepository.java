package br.com.agenda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agenda.domain.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

	Optional<Contact> findByName(String name);
}