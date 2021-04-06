package com.sip.ams.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Map;

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

import com.sip.ams.entities.Like;
import com.sip.ams.services.LikeService;

@RestController
@RequestMapping({"/like"})
@CrossOrigin
public class LikeController {
	@Autowired
	private LikeService likeService;
	@GetMapping("/list")
	 public List<Like> getAllDemandes() {
	 return likeService.listerLikes();
	 }
	@GetMapping("/list/{likeId}")
	 public Like getLikeById(@PathVariable Long likeId) {
	 return likeService.findLikeById(likeId);
	 }
	@GetMapping("/nlike/{pubId}")
	 public int getlikeNumberByPub(@PathVariable Long pubId) {
	 return likeService.nlikes(pubId);
	 }
	@GetMapping("/find/{postid}/{userid}")
	 public Long getLikeUserPost(@PathVariable Long postid,@PathVariable Long userid) {
	 return likeService.findByUserPub(userid, postid);
	 }
	
	@PostMapping("/add")
	 public void createLike( @RequestBody Like like) {
		likeService.addComment(like);	 }
	
	@PutMapping("update/{likeId}")
	 public Like updateLike(@PathVariable Long likeId, @Valid
	@RequestBody Like like) {
		 return likeService.updateLike(likeId, like);
			 }
	 @DeleteMapping("delete/{id}")
	 public void deleteOffer(@PathVariable Long id ) {
	
		 likeService.deleteLike(id);
	 }
}
