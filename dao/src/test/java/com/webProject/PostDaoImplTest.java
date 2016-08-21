package com.webProject;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;

import org.joda.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.webProject.entities.Person;
import com.webProject.entities.Post;
import com.webProject.entities.PostLikes;

/**
 * Created by nsieverska on 13.08.16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/test-context.xml")
public class PostDaoImplTest extends TestAbstractDao {

	@Autowired
	private PostDao postDao;

	private static int numberOf = 1;

	private Post getPost() {
		Post p = new Post();
		p.setContent("content" + numberOf);
		Person person = Utils.getPerson();
		getSession().save(person);
		p.setPerson(person);
		p.setPlaceTime(LocalDateTime.now().toDate());
		p.setTitle("title" + numberOf);
		numberOf++;
		return p;
	}

	@Test
	@Transactional
	@Rollback(true)
	public void likePostTest() {
		//GIVEN
		Person person = Utils.getPerson();
		getSession().save(person);

		Post post = new Post();
		post.setContent("content");
		post.setPerson(person);
		post.setPlaceTime(LocalDateTime.now().toDate());
		post.setTitle("title");
		getSession().save(post);

		//WHEN
		postDao.likePost(post, person);

		//THEN
		PostLikes p = (PostLikes) getSession().createQuery("select p from PostLikes p").uniqueResult();
		assertThat(p.getPerson()).isEqualTo(person);
		assertThat(p.getPost()).isEqualTo(post);
	}


	@Test
	@Transactional
	@Rollback(true)
	public void findPersonsLikesForPostTest() {
		//GIVEN
		Person person1 = Utils.getPerson();
		Person person2 = Utils.getPerson();
		getSession().save(person1);
		getSession().save(person2);

		Post post = new Post();
		post.setContent("content");
		post.setPerson(person1);
		post.setPlaceTime(LocalDateTime.now().toDate());
		post.setTitle("title");
		getSession().save(post);

		PostLikes like1 = new PostLikes(person1, post);
		PostLikes like2 = new PostLikes(person2, post);
		getSession().save(like1);
		getSession().save(like2);

		//WHEN
		List<Post> posts = postDao.findAll();
		Set<Person> persons = postDao.findPersonsLikesForPost(post);

		//THEN
		assertThat(persons.size()).isEqualTo(2);
		assertThat(persons).containsOnly(person1, person2);
	}
}
