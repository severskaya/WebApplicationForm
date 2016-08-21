package com.webProject.implDao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.webProject.entities.PostLikes;
import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.webProject.PostDao;
import com.webProject.entities.Person;
import com.webProject.entities.Post;

/**
 * Created by Северская on 10.07.2016.
 */
@Component
@Transactional
public class PostDaoImpl extends AbstractDao<Post, Long> implements PostDao {

	@Override
	public void likePost(Post post, Person person) {
		getSession().save(new PostLikes(person, post));
	}

	@Override
	public Set<Person> findPersonsLikesForPost(Post post) {
		Query query = getSession().createQuery("select p.person from PostLikes p where p.post = :post").setParameter("post", post);
		return new HashSet<>(query.list());
	}

	@Override
	public Set<Post> findPostsFromPerson(Long personId) {
		Query query = getSession().createQuery("select p from Post p where p.person = :id").setLong("id", personId);
		return new HashSet<>(query.list());
	}

	@Override
	public Post findById(Long id) {
		return findById(id, Post.class);
	}

	@Override
	public List<Post> findAll() {
		return findAll(Post.class);
	}

}
