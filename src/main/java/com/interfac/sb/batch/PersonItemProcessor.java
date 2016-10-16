package com.interfac.sb.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.interfac.sb.person.model.Person;


@Service
public class PersonItemProcessor implements ItemProcessor<Person, Person>{

	private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);
	
	private String threadName;
	
	@Override
	public Person process(Person person) throws Exception {
		log.info(threadName + " processing : "
				+ person.getFirstName() + " " + person.getLastName());
		
		String firstName = person.getFirstName().toUpperCase();
		String lastName = person.getLastName().toUpperCase();
		int id = person.getId();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		
		return person;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}
	
	
}
