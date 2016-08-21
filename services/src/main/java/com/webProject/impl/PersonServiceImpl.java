package com.webProject.impl;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webProject.PersonDao;
import com.webProject.PersonService;
import com.webProject.dto.PersonDto;
import com.webProject.entities.Person;

/**
 * Created by Северская on 10.07.2016.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private DozerBeanMapper mapper;

    @Override
    public Long savePerson(PersonDto personDto) {
        return personDao.save(mapper.map(personDto, Person.class));
    }
}
