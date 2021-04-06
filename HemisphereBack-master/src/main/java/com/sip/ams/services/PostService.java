package com.sip.ams.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sip.ams.entities.Post;


@Service
public interface PostService {
	List<Post> listerComments();
	void addPost(Post post,Long userid);
	Post updatePost(Long id,Post post);
	void deletePost(Long id);
}
