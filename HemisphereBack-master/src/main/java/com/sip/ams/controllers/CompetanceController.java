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

import com.sip.ams.entities.Competance;
import com.sip.ams.entities.Offer_Task_Solution;
import com.sip.ams.services.CommentService;
import com.sip.ams.services.CompetenceService;

@RestController
@RequestMapping({"/competance"})
@CrossOrigin
public class CompetanceController {
	@Autowired
	private CompetenceService competanceService;
	@GetMapping("/list")
	 public List<Competance> getAllCompetance() {
	 return competanceService.listerCompetances();
	 }
	@GetMapping("/list/Competances/{offerId}")
	 public List<Competance> getCompetanceByOffer(@PathVariable Long offerId) {
	 return competanceService.getCompetanceByOfferId(offerId);
	 }
	@GetMapping("/list/offers/{competanceId}")
	 public List<Offer_Task_Solution> getOfferByCompetance(@PathVariable Long competanceId) {
	 return competanceService.getOfferByCompetanceId(competanceId);
	 }
	//@PostMapping("/add")
	// public void createCompetance( @RequestBody Competance Competance) {
	//	competanceService.addCompetance(Competance);
	 //}
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	  public void createCompetance( Competance Competance) {
		competanceService.addCompetance(Competance);
	  }
	@PutMapping("update/{demandeId}")
	 public Competance updateCompetance(@PathVariable Long commentId, @Valid
	@RequestBody Competance cRequest) {
		 return competanceService.updateCompetance(commentId, cRequest);
			 }
	 @DeleteMapping("delete/{demandeId}")
	 public void deleteCompetance(@PathVariable Long commentId) {
		 competanceService.deleteCompetance(commentId);
	 }
}
