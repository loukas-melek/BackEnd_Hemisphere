package com.sip.ams.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sip.ams.entities.General_Post;
import com.sip.ams.entities.Profile;
import com.sip.ams.services.PostService;
import com.sip.ams.services.ProfileService;

@RestController
@RequestMapping({"/profile"})
@CrossOrigin
public class ProfileController {
	@Autowired
	private ProfileService profileService;
	
	@GetMapping("/user/{id}")
	 public Profile getProfileByUserId(@PathVariable Integer id) {
	 return (Profile)profileService.findByUserId(id);
	 }
	
}
