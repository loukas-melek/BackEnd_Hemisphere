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

import com.sip.ams.entities.Application;
import com.sip.ams.services.ApplicationService;
import com.sip.ams.services.Offer_Task_SolutionService;

@RestController
@RequestMapping({"/demandes"})
@CrossOrigin
public class ApplicationController {
	@Autowired
	private ApplicationService applicationService;
	@GetMapping("/list")
	 public List<Application> getAllDemandes() {
	 return applicationService.listerDemande();
	 }
	@GetMapping("/list/user/{userId}")
	 public List<Application> getDemandesByUserId(@PathVariable Long userId) {
	 return applicationService.getDemandeByUserId(userId);
	 }
	@GetMapping("/list/offer/{offerId}")
	 public List<Application> getDemandesByOfferId(@PathVariable Long offerId) {
	 return applicationService.getDemandeByOfferId(offerId);
	 }
	
	@PostMapping("/add")
	 public void createDemande( @RequestBody Application demande) {
	  applicationService.addDemande(demande);
	 }
	
	@PutMapping("update/{demandeId}")
	 public Application updateDemande(@PathVariable Long demandeId, @Valid
	@RequestBody Application dRequest) {
		 return applicationService.updateDemande(demandeId, dRequest);
			 }
	 @DeleteMapping("delete/{demandeId}")
	 public void deleteOffer(@PathVariable int demandeId) {
	 applicationService.deleteDemande(demandeId);
	 }
}
