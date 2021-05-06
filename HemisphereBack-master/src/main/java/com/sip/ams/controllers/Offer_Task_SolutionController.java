package com.sip.ams.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.sip.ams.entities.Offer_Task_Solution;

import com.sip.ams.services.Offer_Task_SolutionService;
import com.sun.istack.Nullable;


@RestController
@CrossOrigin
@RequestMapping({"offers"})
public class Offer_Task_SolutionController {
	@Autowired
	private Offer_Task_SolutionService offer_Task_SolutionService;
	@GetMapping("/list")
	 public List<Offer_Task_Solution> getAllOffers() {
	 return (List<Offer_Task_Solution>) offer_Task_SolutionService.findAll();
	 }

	@GetMapping("/{offerId}")
	 public Offer_Task_Solution getOfferById(@PathVariable long offerId) {
	 return (Offer_Task_Solution) offer_Task_SolutionService.listOfferById(offerId);
	 }
	@GetMapping("/competance/{id}")
	 public List<Long> getListCompetances(@PathVariable Long id) {
	 return (List<Long>) offer_Task_SolutionService.getListCompetance(id);
	 }
	
	/*
	 * @GetMapping("/filter") public List<Offer_Task_Solution> getFiltredListOfOffers(@RequestBody
	 * List<Offer_Task_Solution> listToFilter,@PathParam("location") @Nullable String
	 * location,@PathParam("type")@Nullable String
	 * type,@PathParam("categorie") @Nullable String categorie) {
	 * 
	 * return this.offerService.filterGlobal(listToFilter, location, type,
	 * categorie); }
	 */
	
	
	@PostMapping("/add/{id}")
	 public Offer_Task_Solution createOffer(@RequestBody Offer_Task_Solution offer,@PathVariable Long id) {
	 return offer_Task_SolutionService.addOffer(offer,id);
	 }
	
	@PutMapping("update/{offerId}")
	 public Offer_Task_Solution updateOffer(@PathVariable long offerId, @Valid
	@RequestBody Offer_Task_Solution offerRequest) {
		 return offer_Task_SolutionService.updateOffer(offerId, offerRequest);
			 }
	 @DeleteMapping("delete/{offerId}")
	 public void deleteOffer(@PathVariable long offerId) {
	 offer_Task_SolutionService.deleteOffer(offerId);
	 }
}
