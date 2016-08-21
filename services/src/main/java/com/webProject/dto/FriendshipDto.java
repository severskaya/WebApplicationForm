package com.webProject.dto;

import java.time.LocalDate;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by nsieverska on 13.08.16.
 */
public class FriendshipDto {

	private PersonDto personId;
	private PersonDto friendId;
	private LocalDate dateFrom;

	public FriendshipDto(){}

	public FriendshipDto(PersonDto personId, PersonDto friendId, LocalDate dateFrom) {
		this.personId = personId;
		this.friendId = friendId;
		this.dateFrom = dateFrom;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		FriendshipDto that = (FriendshipDto) o;

		return new EqualsBuilder()
				.append(personId, that.personId)
				.append(friendId, that.friendId)
				.append(dateFrom, that.dateFrom)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(25, 45)
				.append(personId)
				.append(friendId)
				.append(dateFrom)
				.toHashCode();
	}

	public PersonDto getPersonId() {

		return personId;
	}

	public void setPersonId(PersonDto personId) {
		this.personId = personId;
	}

	public PersonDto getFriendId() {
		return friendId;
	}

	public void setFriendId(PersonDto friendId) {
		this.friendId = friendId;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}
}
