package com.sip.ams.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Offer_Task_Solution;


@Service
public interface Offer_Task_SolutionService {

	List<Offer_Task_Solution> listerOffer();
	public List<Offer_Task_Solution> findAll();
	Offer_Task_Solution addOffer(Offer_Task_Solution offer,Long userid);
	Offer_Task_Solution updateOffer(long id,Offer_Task_Solution offer);
	void deleteOffer(long id);
	Offer_Task_Solution listOfferById(long id);
	List<Long> getListCompetance(Long id);


	/*
	 * List<Offer_Task_Solution> getOfferByUserId(Long user_id); List<Offer_Task_Solution>
	 * getOfferByCategorie(String categorie); List<Offer_Task_Solution> getOfferByType(String
	 * type); List<Offer_Task_Solution> getOfferByLocation(String location); public List<Offer_Task_Solution>
	 * filter(String location,String type,String Categorie ); public List<Offer_Task_Solution>
	 * filterLocationType(String location,String type); public List<Offer_Task_Solution>
	 * filterLocationCategorie(String location,String Categorie); public List<Offer_Task_Solution>
	 * filterTypeCategorie(String type,String Categorie ); public List<Offer_Task_Solution>
	 * listerTasks();
	 */
	//List<Offer_Task_Solution> filterGlobal(List<Offer_Task_Solution> listToFilter,String location,String type,String Categorie );

	//public List<Offer_Task_Solution> getOfferByCompany(String company);
}
