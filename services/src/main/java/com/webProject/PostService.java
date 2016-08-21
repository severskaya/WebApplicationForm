package com.webProject;

/**
 * Created by Северская on 10.07.2016.
 */
public interface PostService {

    int getAllLikesForPost(Long postId);

    void likePost(Long postId, String personLogin);
}
