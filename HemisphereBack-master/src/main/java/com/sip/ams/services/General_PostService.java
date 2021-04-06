package com.sip.ams.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sip.ams.entities.General_Post;


@Service
public interface General_PostService {

	List<General_Post> listerPubs();
	void addPub(General_Post offer);
	General_Post updatePub(Long id,General_Post offer);
	void deletePub(Long id);
	General_Post listPubById(Long id);
	List<General_Post> getPubByUserId(Long user_id);
	
	/*
	 * List<General_Post> getPubByCategorie(String categorie); List<General_Post> getPubByType(String
	 * type); List<General_Post> getPubByLocation(String location); public List<General_Post>
	 * filter(String location,String type,String Categorie ); public List<General_Post>
	 * filterLocationType(String location,String type); public List<General_Post>
	 * filterLocationCategorie(String location,String Categorie); public List<General_Post>
	 * filterTypeCategorie(String type,String Categorie ); public List<General_Post>
	 * listerTasks();
	 * */
	 public List<General_Post> listerAll();
	 
	//public List<Offer_Task_Solution> getOfferByCompany(String company);
}
