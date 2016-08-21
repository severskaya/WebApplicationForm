package services.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.webProject.PersonDao;
import com.webProject.PostDao;
import com.webProject.PostService;
import com.webProject.entities.Person;
import com.webProject.entities.Post;

import util.TestServiceUtils;

/**
 * Created by nsieverska on 13.08.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/test-context.xml")
public class PostServiceImplTest {

	@Autowired
	private PostService postService;

	@Autowired
	private PersonDao personDao;

	@Autowired
	private PostDao postDao;

	@Test
	@Transactional
	@Rollback(true)
	public void getAllLikesForPostTest() {
		//GIVEN
		Person person1 = TestServiceUtils.getPerson();
		personDao.save(person1);
		Person person2 = TestServiceUtils.getPerson();
		person2.setLogin("login2");
		personDao.save(person2);
		Post post = TestServiceUtils.getPost();
		post.setPerson(person1);
		postDao.save(post);
		postDao.likePost(post, person1);
		postDao.likePost(post, person2);

		//WHEN
		int likes = postService.getAllLikesForPost(post.getId());

		//THEN
		assertThat(likes).isEqualTo(2);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void likePostTest() {
		//GIVEN
		Person person = TestServiceUtils.getPerson();
		personDao.save(person);
		Post post = TestServiceUtils.getPost();
		post.setPerson(person);
		postDao.save(post);

		//WHEN
		postService.likePost(post.getId(), person.getLogin());

		//THEN
		assertThat(postDao.findPersonsLikesForPost(post).size()).isEqualTo(1);
	}
}
