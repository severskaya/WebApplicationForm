package converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.webProject.PersonDao;
import com.webProject.dto.PersonDto;
import com.webProject.entities.Hobby;
import com.webProject.entities.Person;

import util.TestServiceUtils;


/**
 * Created by nsieverska on 13.08.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/test-context.xml")
public class PersonDozerMappingTest {

	@Autowired
	private DozerBeanMapper mapper;

	@Autowired
	private PersonDao personDao;

	@Test
	@Transactional
	@Rollback(true)
	public void testPersonDtoToEntityMapping() {
		//GIVEN
		Person expectedEntity = TestServiceUtils.getPerson();
		Hobby hobby1 = TestServiceUtils.getHobby();
		Hobby hobby2 = TestServiceUtils.getHobby();
		hobby2.setTitle("Title 2");
		expectedEntity.getHobbies().add(hobby1);
		expectedEntity.getHobbies().add(hobby2);
		Long expectedId = personDao.save(expectedEntity);

		PersonDto dto = TestServiceUtils.getPersonDto();
		dto.setId(expectedId);
		dto.getHobbies().add(hobby1.getId());
		dto.getHobbies().add(hobby2.getId());

		//WHEN
		Person actualEntity = mapper.map(dto, Person.class);

		//THEN
		assertThat(actualEntity.getId()).isEqualTo(expectedId);
		assertThat(actualEntity.getEmail()).isEqualTo(expectedEntity.getEmail());
		assertThat(actualEntity.getBirthday()).isEqualTo(expectedEntity.getBirthday());
		assertThat(actualEntity.getFirstName()).isEqualTo(expectedEntity.getFirstName());
		assertThat(actualEntity.getLastName()).isEqualTo(expectedEntity.getLastName());
		assertThat(actualEntity.getLogin()).isEqualTo(expectedEntity.getLogin());
		assertThat(actualEntity.getHobbies()).isEqualTo(expectedEntity.getHobbies());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testPersonEntityToDtoMapping() {
		Long firstHobbyId = 1L;
		Long secondHobbyId = 2L;
		//GIVEN
		Person entity = TestServiceUtils.getPerson();
		Hobby hobby1 = TestServiceUtils.getHobby();
		Hobby hobby2 = TestServiceUtils.getHobby();
		hobby1.setId(firstHobbyId);
		hobby2.setId(secondHobbyId);
		hobby2.setTitle("Title 2");
		entity.getHobbies().add(hobby1);
		entity.getHobbies().add(hobby2);
		PersonDto expectedDto = TestServiceUtils.getPersonDto();
		expectedDto.getHobbies().add(firstHobbyId);
		expectedDto.getHobbies().add(secondHobbyId);

		//WHEN
		PersonDto actualDto = mapper.map(entity, PersonDto.class);

		//THEN
		assertThat(actualDto.getId()).isEqualTo(expectedDto.getId());
		assertThat(actualDto.getEmail()).isEqualTo(expectedDto.getEmail());
		assertThat(actualDto.getBirthDay()).isEqualTo(expectedDto.getBirthDay());
		assertThat(actualDto.getFirstName()).isEqualTo(expectedDto.getFirstName());
		assertThat(actualDto.getLastName()).isEqualTo(expectedDto.getLastName());
		assertThat(actualDto.getLogin()).isEqualTo(expectedDto.getLogin());
		assertThat(actualDto.getHobbies()).isEqualTo(expectedDto.getHobbies());
	}
}
