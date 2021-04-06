package com.sip.ams.implementservice;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sip.ams.repositories.PostRepository;
import com.sip.ams.repositories.ProfileRepository;
import com.sip.ams.entities.General_Post;
import com.sip.ams.entities.Post;
import com.sip.ams.repositories.General_PostRepository;
import com.sip.ams.repositories.UserRepository;
import com.sip.ams.services.PostService;
@Service
public class PostServiceImp implements PostService {

	
	@Autowired
	private General_PostRepository general_PostRepository;
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private PostRepository postRepository;
	@Override
	public List<Post> listerComments() {
		// TODO Auto-generated method stub
		return postRepository.listerPosts();
	}

	@Override
	public void addPost(Post post,Long userid) {
		// TODO Auto-generated method stub
		postRepository.save(post);
		General_Post p = new General_Post();
		 Date d=new Date();
		p.setCreated_at(d);
		p.setUpdated_at(d);
		p.setPost(post);
		p.setProfile(profileRepository.getOne(userid));
		System.out.println(userid);
		general_PostRepository.save(p);
	}

	@Override
	public Post updatePost(Long id, Post post) {
		// TODO Auto-generated method stub
		Post oldposte = postRepository.getOne(id);
		if(oldposte!=null) {
			oldposte.setContent(post.getContent());
			oldposte.setMedia_path(post.getMedia_path());
		
			postRepository.save(oldposte);
		}
		return oldposte;
	}

	@Override
	public void deletePost(Long id) {
		// TODO Auto-generated method stub
		postRepository.deleteById(id);
	}

}
