package org.learn.springBoot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {
	
	@Id
	private String Id;
	private String FName;
	private String LName;
	
	public Person(String fName, String lName) {
		super();
		this.setFName(fName);
		this.setLName(lName);
	}

	public String getFName() {
		return FName;
	}

	public void setFName(String fName) {
		FName = fName;
	}

	public String getLName() {
		return LName;
	}

	public void setLName(String lName) {
		LName = lName;
	}
	

}
