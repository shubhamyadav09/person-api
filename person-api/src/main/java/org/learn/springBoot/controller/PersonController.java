package org.learn.springBoot.controller;

import java.util.List;

import org.learn.springBoot.model.Person;
import org.learn.springBoot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personServ;
	
	@RequestMapping(method=RequestMethod.POST, value="/create")
	public void create(@RequestParam String FirstName, @RequestParam String LastName) {
		personServ.addPerson(FirstName, LastName);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/welcome")
	public String WelcomeEmployee() {		
		return "Hello Person";
	}

	@RequestMapping(method=RequestMethod.PUT, value="/update/{firstName}")
	public ResponseEntity<HttpStatus> addPerson(@RequestBody Person person, @PathVariable String firstName) {
		personServ.updatePerson(firstName, person);
		
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAll")
	public List<Person> getAllPersons() {
		return personServ.getAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/get")
	public List<Person> getPersons(@RequestParam String FirstName) {
		return personServ.getPersons(FirstName);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete")
	public void deletePerson(@RequestParam String FirstName) {
		personServ.deletePerson(FirstName);
	}
}
