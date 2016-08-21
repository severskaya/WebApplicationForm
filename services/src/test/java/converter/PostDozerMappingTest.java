package converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.webProject.PersonDao;
import com.webProject.PostDao;
import com.webProject.dto.PostDto;
import com.webProject.entities.Person;
import com.webProject.entities.Post;

import util.TestConverterUtils;


/**
 * Created by nsieverska on 13.08.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/test-context.xml")
public class PostDozerMappingTest {

	@Autowired
	private DozerBeanMapper mapper;

	@Autowired
	private PersonDao personDao;

	@Autowired
	private PostDao postDao;

	@Test
	@Transactional
	@Rollback
	public void testPostEntityToDtoMapping() {
		//GIVEN
		Person person = TestConverterUtils.getPerson();
		person.setId(null);
		personDao.save(person);
		String expectedPersonLogin = person.getLogin();

		Post entity = TestConverterUtils.getPost();
		entity.setId(null);
		entity.setPerson(person);
		Long expectedId = postDao.save(entity);

		postDao.likePost(entity, person);

		PostDto expectedDto = TestConverterUtils.getPostDto();

		//WHEN
		PostDto actualDto = mapper.map(entity, PostDto.class);

		//THEN
		assertThat(actualDto.getPostId()).isEqualTo(expectedId);
		assertThat(actualDto.getContent()).isEqualTo(expectedDto.getContent());
		assertThat(actualDto.getTitle()).isEqualTo(expectedDto.getTitle());
		assertThat(actualDto.getPlaceTime()).isEqualTo(expectedDto.getPlaceTime());
		assertThat(actualDto.getAuthorLogin()).isEqualTo(expectedPersonLogin);
		assertThat(actualDto.getPostLikes()).isEqualTo(1L);
	}

	@Test
	@Transactional
	@Rollback
	public void testPostDtoToEntityMapping() {
		//GIVEN
		PostDto dto = TestConverterUtils.getPostDto();
		Post expectedEntity = TestConverterUtils.getPost();
		personDao.save(expectedEntity.getPerson());

		//WHEN
		Post actualEntity = mapper.map(dto, Post.class);

		//THEN
		assertThat(actualEntity.getId()).isEqualTo(expectedEntity.getId());
		assertThat(actualEntity.getContent()).isEqualTo(expectedEntity.getContent());
		assertThat(actualEntity.getTitle()).isEqualTo(expectedEntity.getTitle());
		assertThat(actualEntity.getPlaceTime()).isEqualTo(expectedEntity.getPlaceTime());
		assertThat(actualEntity.getPerson()).isEqualTo(expectedEntity.getPerson());
	}
}
