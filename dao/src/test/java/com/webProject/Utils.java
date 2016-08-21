package com.webProject;


import java.util.Date;

import org.joda.time.LocalDate;

import com.webProject.entities.Person;

/**
 * Created by nsieverska on 13.08.16.
 */
public class Utils {

	private static int numberOfPerson = 1;

	private static Date TEST_DATE = LocalDate.now().toDate();

	public static Person getPerson() {
		Person person = new Person();
		person.setId(Long.valueOf(numberOfPerson));
		person.setFirstName("Garry");
		person.setLastName("Oldman");
		person.setLogin("garryOldman" + numberOfPerson);
		person.setEmail("a@a.com");
		person.setBirthday(TEST_DATE);
		numberOfPerson++;
		return person;
	}

	public static Date getTestDate() {
		return TEST_DATE;
	}
}
