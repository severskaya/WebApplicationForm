package com.webProject.implDao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.webProject.PersonDao;
import com.webProject.entities.Person;

/**
 * Created by Северская on 10.07.2016.
 */
@Component
@Transactional
public class PersonDaoImpl extends AbstractDao<Person, Long> implements PersonDao {

	@Override
	public Person findByLogin(String login) {
		Query query = getSession().createQuery("select p from Person p where p.login=:login").setString("login", login);
		return (Person) query.uniqueResult();
	}

	@Override
	public Person findById(Long id) {
		return findById(id, Person.class);
	}

	@Override
	public List<Person> findAll() {
		return findAll(Person.class);
	}
}
