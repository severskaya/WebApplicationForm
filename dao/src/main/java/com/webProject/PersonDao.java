package com.webProject;

import org.springframework.transaction.annotation.Transactional;

import com.webProject.entities.Person;

/**
 * Created by Северская on 10.07.2016.
 */
@Transactional
public interface PersonDao extends GenericDao<Person, Long>{

	Person findByLogin(String login);
}
