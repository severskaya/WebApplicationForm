package com.webProject;

import java.util.Set;

import com.webProject.entities.Person;
import com.webProject.entities.Post;

/**
 * Created by Северская on 10.07.2016.
 */
public interface PostDao extends GenericDao<Post, Long> {

	void likePost(Post post, Person person);

	Set<Person> findPersonsLikesForPost(Post post);

	Set<Post> findPostsFromPerson(Long personId);


}
