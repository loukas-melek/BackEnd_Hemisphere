package com.sip.ams.controllers;

import java.io.FileNotFoundException;

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

import com.sip.ams.entities.Application;
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
	
	@GetMapping("/list")
	 public Profile listProfiles() {
	 return (Profile)profileService.listerProfiles();
	 }
	@PostMapping("/add")
	 public void createProfile( @RequestBody Profile profile) {
		profileService.addProfile(profile);
	 }
	@GetMapping("/user/{id}")
	 public Profile getProfileByUserId(@PathVariable Integer id)  {
	 return (Profile)profileService.findByUserId(id);
	 }
	@PutMapping("update/{profileId}")
	 public Profile updateProfile(@PathVariable Long profileId, @Valid
	@RequestBody Profile profile) {
		 return profileService.updateProfile(profileId, profile);
			 }
	 @DeleteMapping("delete/{profileId}")
	 public void deleteOffer(@PathVariable Long profileId) {
		 profileService.deleteProfile(profileId);
	 }
}
