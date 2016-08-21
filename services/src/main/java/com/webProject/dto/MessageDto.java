package com.webProject.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.LocalDateTime;

/**
 * Created by nsieverska on 13.08.16.
 */
public class MessageDto {

	private Long id;
	private String content;
	private LocalDateTime timeSent;
	private PersonDto personFrom;
	private PersonDto personTo;

	public MessageDto() {
	}

	public MessageDto(Long messageId, String content, LocalDateTime timeSent, PersonDto personFrom, PersonDto personTo) {

		this.id = messageId;
		this.content = content;
		this.timeSent = timeSent;
		this.personFrom = personFrom;
		this.personTo = personTo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getTimeSent() {
		return timeSent;
	}

	public void setTimeSent(LocalDateTime timeSent) {
		this.timeSent = timeSent;
	}

	public PersonDto getPersonFrom() {
		return personFrom;
	}

	public void setPersonFrom(PersonDto personFrom) {
		this.personFrom = personFrom;
	}

	public PersonDto getPersonTo() {
		return personTo;
	}

	public void setPersonTo(PersonDto personTo) {
		this.personTo = personTo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		MessageDto that = (MessageDto) o;

		return new EqualsBuilder()
				.append(id, that.id)
				.append(content, that.content)
				.append(timeSent, that.timeSent)
				.append(personFrom, that.personFrom)
				.append(personTo, that.personTo)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(25, 45)
				.append(id)
				.append(content)
				.append(timeSent)
				.append(personFrom)
				.append(personTo)
				.toHashCode();
	}
}
