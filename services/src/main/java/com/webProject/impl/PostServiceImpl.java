package com.webProject.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webProject.PersonDao;
import com.webProject.PostDao;
import com.webProject.PostService;
import com.webProject.entities.Post;

/**
 * Created by Северская on 10.07.2016.
 */

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private PersonDao personDao;

    @Override
    public int getAllLikesForPost(Long postId) {
        Post post = postDao.findById(postId);
        return postDao.findPersonsLikesForPost(post).size();
    }

    @Override
    public void likePost(Long postId, String personLogin) {
        postDao.likePost(postDao.findById(postId), personDao.findByLogin(personLogin));
    }
}
