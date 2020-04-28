package org.learn.springBoot.service;

import org.learn.springBoot.model.Person;
import org.learn.springBoot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepo;
	
	public Person addPerson(String fName, String LName) {
		return personRepo.save(new Person(fName, LName));
	}

}
