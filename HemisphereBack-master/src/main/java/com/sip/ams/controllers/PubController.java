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
import org.springframework.web.bind.annotation.RestController;

import com.sip.ams.entities.General_Post;
import com.sip.ams.services.General_PostService;
import com.sun.istack.Nullable;


@RestController
@CrossOrigin
@RequestMapping({"pub"})
public class PubController {
	@Autowired
	private General_PostService general_PostService;
	@GetMapping("/list")
	 public List<General_Post> getAllPubs() {
	 return (List<General_Post>) general_PostService.listerAll();
	 }

	
	@GetMapping("/{pubId}")
	 public General_Post getPubById(@PathVariable Long pubId) {
	 return (General_Post)general_PostService.listPubById(pubId);
	 }
	@GetMapping("/user/{userId}")
	 public List<General_Post> getPubByUserId(@PathVariable Long userId) {
	 return (List<General_Post>) general_PostService.getPubByUserId(userId);
	 }

	/*
	 * @GetMapping("/tasks") public List<General_Post> getTasks() { return (List<General_Post>)
	 * offerService.listerTasks(); }
	 * 
	 * @GetMapping("/post") public List<General_Post> getPosts() { return (List<General_Post>)
	 * offerService.listerPubs(); }
	 * 
	 * @GetMapping("/filter/tasks") public List<General_Post>
	 * getFiltredTasks(@PathParam("location") @Nullable String
	 * location,@PathParam("categorie") @Nullable String categorie) {
	 * 
	 * return this.offerService.filterLocationCategorie(location, categorie); }
	 * 
	 * @GetMapping("/filter") public List<General_Post>
	 * getOffersByCategorie(@PathParam("location") @Nullable String
	 * location,@PathParam("type")@Nullable String
	 * type,@PathParam("categorie") @Nullable String categorie) {
	 * 
	 * return this.offerService.filter(location, type, categorie); }
	 * 
	 * @GetMapping("categorie/{categorie}") public List<General_Post>
	 * getOffersByCategorie(@PathVariable String categorie) { return (List<General_Post>)
	 * offerService.getOfferByCategorie(categorie); }
	 * 
	 * @GetMapping("type/{type}") public List<General_Post> getOffersByType(@PathVariable
	 * String type) { return (List<General_Post>) offerService.getOfferByType(type); }
	 * 
	 * @GetMapping("location/{location}") public List<General_Post>
	 * getOffersByLocation(@PathVariable String location) { return (List<General_Post>)
	 * offerService.getOfferByLocation(location); }
	 */
	@PostMapping("/add")
	 public void createOffer(@RequestBody General_Post offer) {
		general_PostService.addPub(offer);
	 }
	@PutMapping("update/{pubId}")
	 public General_Post updateOffer(@PathVariable Long pubId, @Valid
	@RequestBody General_Post pubRequest) {
		 return general_PostService.updatePub(pubId, pubRequest);
			 }
	 @DeleteMapping("delete/{pubId}")
	 public void deleteOffer(@PathVariable Long pubId) {
		 general_PostService.deletePub(pubId);
	 }
}
