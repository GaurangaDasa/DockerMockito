package model;

import java.util.ArrayList;
import java.util.List;



public class StorageService {
	
	public List<Person> db = new ArrayList<Person>();
	
	public void add(Person person){
		Person newPerson = new Person();
		newPerson.setFirstName(person.getFirstName());
		newPerson.setYob(person.getYob());
		db.add(newPerson);
	}
	
	public List<Person> getAllPersons(){
		return db;
	}

}
