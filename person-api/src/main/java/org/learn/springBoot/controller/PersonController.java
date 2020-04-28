package org.learn.springBoot.controller;

import org.learn.springBoot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
