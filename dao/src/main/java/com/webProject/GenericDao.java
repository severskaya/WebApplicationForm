package com.webProject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by nsieverska on 05.08.16.
 */
public interface GenericDao<T, PK extends Serializable> {

	PK save(T value);

	void update(T value);

	void deleteAll(T... value);

	List<T> findAll();

	T findById(PK id);
}
