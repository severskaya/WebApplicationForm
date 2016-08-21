package com.webProject.implDao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;
import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.webProject.FriendshipDao;
import com.webProject.entities.Friendship;

/**
 * Created by nsieverska on 20.08.16.
 */
@Component
@Transactional
public class FreindshipDaoImpl extends AbstractDao<Friendship, Pair<Long, Long>> implements FriendshipDao {

	@Override
	public List<Friendship> findAll() {
		return null;
	}

	@Override
	public Friendship findById(Pair<Long, Long> id) {
		return null;
	}

	@Override
	public Pair<Long, Long> save(Friendship value) {
		Friendship savedFriendship = (Friendship) getSession().save(value);
		Long personId = savedFriendship.getPerson().getId();
		Long friendId = savedFriendship.getFriend().getId();
		return Pair.of(personId, friendId);
	}

	@Override
	public Set<Friendship> findFriendshipsForPerson(Long personId) {
		Query query = getSession().createQuery("select f from Friendship f where f.person.id=:person").setLong("person", personId);
		return new HashSet<>(query.list());
	}
}
