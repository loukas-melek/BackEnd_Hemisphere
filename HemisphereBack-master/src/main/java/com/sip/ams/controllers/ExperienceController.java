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

import com.sip.ams.entities.Experience;
import com.sip.ams.entities.Profile;
import com.sip.ams.services.ExperienceService;
import com.sip.ams.services.ProfileService;

@RestController
@RequestMapping({"/experience"})
@CrossOrigin
public class ExperienceController {
	@Autowired
	private ExperienceService experienceService;
	
	@GetMapping("/list")
	 public Experience listProfiles() {
	 return (Experience)experienceService.listerExperiences();
	 }
	@PostMapping("/add")
	 public void createExperience( @RequestBody Experience experience) {
		experienceService.addPub(experience);
	 }
	@GetMapping("/profile/{id}")
	 public List<Experience> getExperienceByUserId(@PathVariable Long id) {
	 return (List<Experience>)experienceService.getExperienceByUserId(id);
	 }
	@PutMapping("update/{experienceId}")
	 public Experience updateProfile(@PathVariable Long experienceId, @Valid
	@RequestBody Experience experience) {
		System.out.println("controller"+experience.getDescription());
		 return experienceService.updateExperience(experienceId, experience);
			 }
	 @DeleteMapping("delete/{experienceId}")
	 public void deleteOffer(@PathVariable Long experienceId) {
		 experienceService.deleteExperience(experienceId);
	 }
}
