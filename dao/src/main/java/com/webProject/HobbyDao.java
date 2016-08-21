package com.webProject;

import com.webProject.entities.Hobby;

/**
 * Created by Северская on 10.07.2016.
 */
public interface HobbyDao extends GenericDao<Hobby, Long> {

	Hobby findHobbyByTitle(String title);
}
