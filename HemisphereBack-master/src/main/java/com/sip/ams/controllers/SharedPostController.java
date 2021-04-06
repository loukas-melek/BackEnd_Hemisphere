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
import org.springframework.web.bind.annotation.RestController;

import com.sip.ams.entities.SharedPost;
import com.sip.ams.services.SharedPostService;

@RestController
@RequestMapping({"/sharedpost"})
@CrossOrigin
public class SharedPostController {
	@Autowired
	private SharedPostService sharedPostService;
	@GetMapping("/list")
	 public List<SharedPost> getAllSPosts() {
	 return sharedPostService.listerSharedPost();
	 }
	@GetMapping("/count/{id}")
	 public int getSharesNumber(@PathVariable Long id) {
	 return sharedPostService.nshare(id);
	 }
	@PostMapping("/add/{id}")
	 public void createSPost( @RequestBody SharedPost spost,@PathVariable Long id) {
		sharedPostService.addSharedPost(spost,id);
	 }
	@PutMapping("update/{demandeId}")
	 public SharedPost updateReact(@PathVariable Long commentId, @Valid
	@RequestBody SharedPost cRequest) {
		 return sharedPostService.updateSharedPost(commentId, cRequest);
			 }
	 @DeleteMapping("delete/{demandeId}")
	 public void deleteSPost(@PathVariable Long commentId) {
		 sharedPostService.deleteSharedPost(commentId);;
	 }
}
