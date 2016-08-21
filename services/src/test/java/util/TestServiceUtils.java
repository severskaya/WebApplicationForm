package util;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import com.webProject.dto.HobbyDto;
import com.webProject.dto.PersonDto;
import com.webProject.dto.PostDto;
import com.webProject.entities.Hobby;
import com.webProject.entities.Message;
import com.webProject.entities.Person;
import com.webProject.entities.Place;
import com.webProject.entities.Post;

/**
 * Created by nsieverska on 13.08.16.
 */
public class TestServiceUtils {

	private static final LocalDate TEST_DATE = LocalDate.now();
	private static final LocalDateTime TEST_DATE_TIME = LocalDateTime.now();

	public static LocalDate getTestDate() {
		return TEST_DATE;
	}

	public static LocalDateTime getTestDateTime() {
		return TEST_DATE_TIME;
	}

	public static Person getPerson() {
		Person person = new Person();
		person.setBirthday(TEST_DATE.toDate());
		person.setFirstName("Garry");
		person.setLastName("Oldman");
		person.setLogin("garryOldman");
		person.setEmail("a@a.com");
		return person;
	}

	public static Hobby getHobby() {
		Hobby hobby = new Hobby();
		hobby.setTitle("Some title");
		hobby.setDescription("Some description");
		return hobby;
	}

	public static Post getPost() {
		Post post = new Post();
		post.setTitle("Some title");
		post.setContent("Some comtemt");
		post.setPerson(getPerson());
		post.setPlaceTime(TEST_DATE_TIME.toDate());
		return post;
	}

	public static Place getPlace() {
		Place place = new Place();
		place.setTitle("Some title");
		place.setDescription("Some description");
		place.setLatitude(10.5F);
		place.setLongitude(10.5F);
		return place;
	}

	public static Message getMessage() {
		Message message = new Message();
		message.setTimeSent(TEST_DATE_TIME.toDate());
		message.setContent("Some content");
		return message;
	}

	public static PersonDto getPersonDto() {
		PersonDto personDto = new PersonDto();
		personDto.setBirthDay(TEST_DATE.toString());
		personDto.setFirstName("Garry");
		personDto.setLastName("Oldman");
		personDto.setLogin("garryOldman");
		personDto.setEmail("a@a.com");
		return personDto;
	}

	public static HobbyDto getHobbyDto() {
		HobbyDto hobbyDto = new HobbyDto();
		hobbyDto.setTitle("Some title");
		hobbyDto.setDescription("Some description");
		return hobbyDto;
	}

	public static PostDto getPostDto() {
		PostDto postDto = new PostDto();
		postDto.setTitle("Some title");
		postDto.setContent("Some content");
		postDto.setAuthorLogin(getPersonDto().getLogin());
		postDto.setPlaceTime(TEST_DATE_TIME);
		return postDto;
	}
}
