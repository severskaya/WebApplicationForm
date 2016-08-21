package services.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.webProject.HobbyDao;
import com.webProject.PersonDao;
import com.webProject.PersonService;
import com.webProject.dto.PersonDto;
import com.webProject.entities.Hobby;
import com.webProject.entities.Person;

import util.TestServiceUtils;

/**
 * Created by nsieverska on 13.08.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/test-context.xml")
public class PersonServiceImplTest {

	@Autowired
	private PersonDao personDao;

	@Autowired
	private PersonService personService;

	@Autowired
	private HobbyDao hobbyDao;


	@Test
	@Transactional
	@Rollback(true)
	public void savePersonTest() {
		//GIVEN
		PersonDto personDto = TestServiceUtils.getPersonDto();
		Hobby hobbyToSave = TestServiceUtils.getHobby();
		Long hobbyId = hobbyDao.save(hobbyToSave);
		personDto.getHobbies().add(hobbyId);

		//WHEN
		Long savedPersonId = personService.savePerson(personDto);

		//THEN
		Person savedPerson = personDao.findById(savedPersonId);
		assertThat(savedPerson.getId()).isNotNull();
		assertThat(savedPerson.getEmail()).isEqualTo(personDto.getEmail());
		assertThat(savedPerson.getBirthday()).isEqualTo(personDto.getBirthDay());
		assertThat(savedPerson.getFirstName()).isEqualTo(personDto.getFirstName());
		assertThat(savedPerson.getLastName()).isEqualTo(personDto.getLastName());
		assertThat(savedPerson.getLogin()).isEqualTo(personDto.getLogin());
		assertThat(savedPerson.getHobbies().size()).isEqualTo(1);
		Hobby hobby = new ArrayList<>(savedPerson.getHobbies()).get(0);
		assertThat(hobby.getId()).isNotNull();
		assertThat(hobby.getDescription()).isEqualTo(hobbyToSave.getDescription());
		assertThat(hobby.getTitle()).isEqualTo(hobbyToSave.getTitle());
	}
}
