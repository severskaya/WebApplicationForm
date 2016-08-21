package com.webProject;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.webProject.entities.Person;

/**
 * Created by nsieverska on 13.08.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/test-context.xml")
public class PersonDaoImplTest extends TestAbstractDao {

	@Autowired
	private PersonDao personDao;

	private static final String FIRST_NAME = "Garry";
	private static final String LAST_NAME = "Oldman";
	private static final String EMAIL = "a@a.com";

	@Test
	@Transactional
	@Rollback(true)
	public void findPersonByLoginTest() {
		//GIVEN
		Person person = Utils.getPerson();
		String personLogin = person.getLogin();
		personDao.save(person);

		//WHEN
		Person foundPerson = personDao.findByLogin(personLogin);

		//THEN
		assertThat(foundPerson.getLogin()).isEqualTo(personLogin);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void savePersonTest() {
		//GIVEN
		Person person = Utils.getPerson();
		String personLogin = person.getLogin();

		//WHEN
		personDao.save(person);

		//THEN
		assertThat(personDao.findAll().size()).isEqualTo(1);
		Person savedPerson = personDao.findAll().get(0);
		assertThat(savedPerson.getFirstName()).isEqualTo(FIRST_NAME);
		assertThat(savedPerson.getLastName()).isEqualTo(LAST_NAME);
		assertThat(savedPerson.getLogin()).isEqualTo(personLogin);
		assertThat(savedPerson.getEmail()).isEqualTo(EMAIL);
		assertThat(savedPerson.getBirthday()).isEqualTo(Utils.getTestDate());
		assertThat(savedPerson.getHobbies().size()).isEqualTo(2);
	}
}
