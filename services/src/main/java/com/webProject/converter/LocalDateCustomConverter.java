package com.webProject.converter;

import java.util.Date;

import org.dozer.DozerConverter;
import org.joda.time.LocalDate;

/**
 * Created by nsieverska on 13.08.16.
 */
public class LocalDateCustomConverter extends DozerConverter<LocalDate, Date> {

	public LocalDateCustomConverter() {
		super(LocalDate.class, Date.class);
	}

	@Override
	public Date convertTo(final LocalDate source, final Date destination) {

		if (source == null) {
			return null;
		}

		return source.toDate();
	}

	@Override
	public LocalDate convertFrom(final Date source, final LocalDate destination) {

		if (source == null) {
			return null;
		}
		return new LocalDate(source);
	}
}
