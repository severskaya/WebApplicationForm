package com.webProject.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by nsieverska on 13.08.16.
 */
public class PlaceDto {

	private Long id;
	private String title;
	private String description;
	private Long latitude;
	private Long longitude;
	private List<PersonDto> persons = new ArrayList<>();

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		PlaceDto placeDto = (PlaceDto) o;

		return new EqualsBuilder()
				.append(id, placeDto.id)
				.append(title, placeDto.title)
				.append(description, placeDto.description)
				.append(latitude, placeDto.latitude)
				.append(longitude, placeDto.longitude)
				.append(persons, placeDto.persons)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(25, 45)
				.append(id)
				.append(title)
				.append(description)
				.append(latitude)
				.append(longitude)
				.append(persons)
				.toHashCode();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	public Long getLongitude() {
		return longitude;
	}

	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}

	public List<PersonDto> getPersons() {
		return persons;
	}

	public void setPersons(List<PersonDto> persons) {
		this.persons = persons;
	}

	public PlaceDto() {

	}

	public PlaceDto(Long placeId, String title, String description, Long latitude, Long longitude,
			List<PersonDto> persons) {

		this.id = placeId;
		this.title = title;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
		this.persons = persons;
	}
}
