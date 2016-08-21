package util;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import com.webProject.dto.HobbyDto;
import com.webProject.dto.PersonDto;
import com.webProject.dto.PostDto;
import com.webProject.entities.Hobby;
import com.webProject.entities.Person;
import com.webProject.entities.Post;

/**
 * Created by nsieverska on 13.08.16.
 */
public class TestConverterUtils {

	public static LocalDate getTestDate() {
		return TestServiceUtils.getTestDate();
	}

	public static LocalDateTime getTestDateTime() {
		return TestServiceUtils.getTestDateTime();
	}

	public static Person getPerson() {
		Person person = TestServiceUtils.getPerson();
		person.setId(1L);
		return person;
	}

	public static Hobby getHobby() {
		Hobby hobby = TestServiceUtils.getHobby();
		hobby.setId(1L);
		return hobby;
	}

	public static Post getPost() {
		Post post = TestServiceUtils.getPost();
		post.setId(1L);
		return post;
	}

	public static PersonDto getPersonDto() {
		PersonDto personDto = TestServiceUtils.getPersonDto();
		personDto.setId(1L);
		return personDto;
	}

	public static HobbyDto getHobbyDto() {
		HobbyDto hobbyDto = TestServiceUtils.getHobbyDto();
		hobbyDto.setId(1L);
		return hobbyDto;
	}

	public static PostDto getPostDto() {
		PostDto postDto = TestServiceUtils.getPostDto();
		postDto.setPostId(1L);
		return postDto;
	}
}
