package com.webProject.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by nsieverska on 13.08.16.
 */
public class HobbyDto {

	private String description;
	private String title;
	private Long id;

	public HobbyDto() {
	}

	public HobbyDto(String description, String title, Long hobbyId) {
		this.description = description;
		this.title = title;
		this.id = hobbyId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		HobbyDto hobbyDto = (HobbyDto) o;

		return new EqualsBuilder()
				.append(id, hobbyDto.id)
				.append(title, hobbyDto.title)
				.append(description, hobbyDto.description)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(25, 45)
				.append(id)
				.append(title)
				.append(description)
				.toHashCode();
	}
}
