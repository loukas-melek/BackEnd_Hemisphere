package com.sip.ams.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sip.ams.entities.Post;
import com.sip.ams.services.PostService;

@RestController
@RequestMapping({"/post"})
@CrossOrigin
public class PostController {
	@Autowired
	private PostService postService;
	@GetMapping("/list")
	 public List<Post> getAllDemandes() {
	 return postService.listerComments();
	 }
	@PostMapping("/add/{id}")
	 public void createPost( @RequestBody Post demande,@PathVariable Long id) {
		postService.addPost(demande,id);
	 }
	//@RequestMapping(path = "/add", method = RequestMethod.POST)
	  //public void createPost( Post post) {
		//postService.addPost(post);
	  //}
	@PutMapping("update/{demandeId}")
	 public Post updatePost(@PathVariable Long demandeId, @Valid
	@RequestBody Post dRequest) {
		 return postService.updatePost(demandeId, dRequest);
			 }
	 @DeleteMapping("delete/{demandeId}")
	 public void deletePost(@PathVariable Long demandeId) {
		postService.deletePost(demandeId);
	 }
}
