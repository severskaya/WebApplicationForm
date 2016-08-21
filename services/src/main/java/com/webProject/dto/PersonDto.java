package com.webProject.dto;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by nsieverska on 13.08.16.
 */
public class PersonDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String login;
	private String birthDay;
	private Set<Long> hobbies = new HashSet<>();

	public PersonDto(Long personId, String firstName, String lastName, String email, String login, String birthDay,
			Set<Long> hobbies) {
		this.id = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.login = login;
		this.birthDay = birthDay;
		this.hobbies = hobbies;
	}

	public PersonDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public Set<Long> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Set<Long> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		PersonDto personDto = (PersonDto) o;

		return new EqualsBuilder()
				.append(id, personDto.id)
				.append(firstName, personDto.firstName)
				.append(lastName, personDto.lastName)
				.append(email, personDto.email)
				.append(login, personDto.login)
				.append(birthDay, personDto.birthDay)
				.append(hobbies, personDto.hobbies)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(25, 45)
				.append(id)
				.append(firstName)
				.append(lastName)
				.append(email)
				.append(login)
				.append(birthDay)
				.append(hobbies)
				.toHashCode();
	}
}
