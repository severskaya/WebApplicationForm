package com.webProject;

import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

import com.webProject.entities.Friendship;

/**
 * Created by nsieverska on 20.08.16.
 */
public interface FriendshipDao extends GenericDao<Friendship, Pair<Long, Long>> {

	Set<Friendship> findFriendshipsForPerson(Long personId);
}
