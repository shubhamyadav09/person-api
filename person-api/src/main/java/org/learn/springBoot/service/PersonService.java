package org.learn.springBoot.service;

import java.util.List;

import org.learn.springBoot.model.Person;
import org.learn.springBoot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepo;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	public Person addPerson(String fName, String LName) {
		return personRepo.save(new Person(fName, LName));
	}

	public void updatePerson(String firstName, Person person) {
		Query q = new Query();
		q.addCriteria(Criteria.where("FirstName").is(firstName));		
		mongoTemplate.findAndReplace(q, person);
	}

	public List<Person> getAll() {
		return personRepo.findAll();
		
	}

	public List<Person> getPersons(String firstName) {
		Query q = new Query();
		q.addCriteria(Criteria.where("FirstName").is(firstName));
		
		return mongoTemplate.find(q, Person.class);
	}

	public void deletePerson(String firstName) {
		Query q = new Query();
		q.addCriteria(Criteria.where("FirstName").is(firstName));
		Person p = mongoTemplate.findOne(q, Person.class);
		personRepo.delete(p);	
	}
}
