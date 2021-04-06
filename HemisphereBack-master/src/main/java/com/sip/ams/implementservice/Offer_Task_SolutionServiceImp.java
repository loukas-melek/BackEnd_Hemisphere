package com.sip.ams.implementservice;


import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.General_Post;
import com.sip.ams.entities.Offer_Task_Solution;

import com.sip.ams.repositories.Offer_Task_SolutionRepository;
import com.sip.ams.repositories.ProfileRepository;
import com.sip.ams.repositories.General_PostRepository;

import com.sip.ams.services.Offer_Task_SolutionService;

@Service

public class Offer_Task_SolutionServiceImp implements Offer_Task_SolutionService {

	@Autowired
	private General_PostRepository general_PostRepository;
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private Offer_Task_SolutionRepository offerrepository;

	@Override
	public List<Offer_Task_Solution> listerOffer() {
		// TODO Auto-generated method stub
		return offerrepository.findAll();
	}

	@Override
	public Offer_Task_Solution listOfferById(long id) {
		Offer_Task_Solution r = offerrepository.findOfferById(id);
		return r;

	}

	@Override
	public void addOffer(Offer_Task_Solution offer,Long userid) {
		offerrepository.save(offer);
		 General_Post p= new General_Post();
		 Date d=new Date();
		 p.setCreated_at(d);
		 p.setUpdated_at(d); 
		 p.setOffer(offer);
		p.setProfile(profileRepository.getOne(userid));
		 
		general_PostRepository.save(p);

	}

	@Override
	public Offer_Task_Solution updateOffer(long id, Offer_Task_Solution offer) {

		Offer_Task_Solution oldOffer = offerrepository.findOfferById(id);
		if (oldOffer != null) {
			oldOffer.setCategorie(offer.getCategorie());
			oldOffer.setCost(offer.getCost());
			oldOffer.setDescription(offer.getDescription());
			oldOffer.setIsSupervised(offer.getIsSupervised());
			oldOffer.setStudentNumber(offer.getStudentNumber());
			oldOffer.setTitle(offer.getTitle());
			oldOffer.setLocation(offer.getLocation());
			oldOffer.setIpath(offer.getIpath());
			oldOffer.setPoste(offer.getPoste());
			oldOffer.setType(offer.getType());
			oldOffer.setCompetance(offer.getCompetance());
			offerrepository.save(oldOffer);
		}
		return oldOffer;
	}

	@Override
	public void deleteOffer(long id) {
		offerrepository.deleteById(id);

	}

	/*
	 * @Override public List<Offer_Task_Solution> getOfferByUserId(Long id) { return
	 * offerrepository.getOfferByUserId(id); }
	 * 
	 * @Override public List<Offer_Task_Solution> getOfferByCompany(String company) {
	 * 
	 * return offerrepository.getOfferByCompany(company); }
	 * 
	 * @Override public List<Offer_Task_Solution> getOfferByCategorie(String categorie) { // TODO
	 * Auto-generated method stub return
	 * offerrepository.getOfferByCategorie(categorie); }
	 * 
	 * @Override public List<Offer_Task_Solution> getOfferByType(String type) { // TODO
	 * Auto-generated method stub return offerrepository.getOfferByType(type); }
	 * 
	 * @Override public List<Offer_Task_Solution> getOfferByLocation(String location) { // TODO
	 * Auto-generated method stub return
	 * offerrepository.getOfferByLocation(location); }
	 * 
	 * @Override public List<Offer_Task_Solution> filter(String location, String type, String
	 * categorie) { List<Offer_Task_Solution> offreByLocation = this.getOfferByLocation(location);
	 * List<Offer_Task_Solution> offreByType = this.getOfferByType(type); List<Offer_Task_Solution>
	 * offreByCategorie = this.getOfferByCategorie(categorie); List<Offer_Task_Solution>
	 * offreByLocationAndType = this.filterLocationType(location, type); List<Offer_Task_Solution>
	 * offreByLocationAndCategorie = this.filterLocationCategorie(location,
	 * categorie); List<Offer_Task_Solution> offreByCategorieAndType =
	 * this.filterTypeCategorie(type, categorie); List<Offer_Task_Solution> offreByAllOptions =
	 * this.offerrepository.filter(location, type, categorie); List<Offer_Task_Solution> retour =
	 * new ArrayList();
	 * if(!offreByLocation.isEmpty()&&offreByType.isEmpty()&&offreByCategorie.
	 * isEmpty()) {
	 * 
	 * return offreByLocation; }if(offreByLocation.isEmpty()&&
	 * !offreByType.isEmpty()&&offreByCategorie.isEmpty()) { //if(type=="All")
	 * {return this.listerOffer();} retour= offreByType;
	 * 
	 * }if(offreByLocation.isEmpty()&& offreByType.isEmpty()&&
	 * !offreByCategorie.isEmpty()) { //if(categorie=="All") {return
	 * this.listerOffer();} retour= offreByCategorie; }
	 * if(!offreByLocation.isEmpty()&& offreByType.isEmpty()&&
	 * !offreByCategorie.isEmpty()) {
	 * 
	 * retour= offreByLocationAndCategorie; } if(!offreByLocation.isEmpty()&&
	 * !offreByType.isEmpty()&& offreByCategorie.isEmpty()) {
	 * 
	 * retour= offreByLocationAndType; } if(offreByLocation.isEmpty()&&
	 * !offreByType.isEmpty()&& !offreByCategorie.isEmpty()) {
	 * 
	 * retour= offreByCategorieAndType; } if(!offreByLocation.isEmpty()&&
	 * !offreByType.isEmpty()&& !offreByCategorie.isEmpty()) {
	 * 
	 * retour= offreByAllOptions; }
	 * 
	 * return retour;
	 * 
	 * 
	 * }
	 * 
	 * @Override public List<Offer_Task_Solution> filterLocationType(String location, String type)
	 * { // TODO Auto-generated method stub return
	 * offerrepository.filterLocationType(location, type); }
	 * 
	 * @Override public List<Offer_Task_Solution> filterLocationCategorie(String location, String
	 * Categorie) { // TODO Auto-generated method stub return
	 * offerrepository.filterLocationCategorie(location, Categorie); }
	 * 
	 * @Override public List<Offer_Task_Solution> filterTypeCategorie(String type, String
	 * Categorie) { // TODO Auto-generated method stub return
	 * offerrepository.filterTypeCategorie(type, Categorie); }
	 * 
	 * @Override public List<Offer_Task_Solution> listerTasks() { // TODO Auto-generated method
	 * stub return offerrepository.listerTasks(); }
	 */
	@Override
	public List<Offer_Task_Solution> findAll() {
		// TODO Auto-generated method stub
		return offerrepository.findAll();
	}

	/*
	 * @Override public List<Offer_Task_Solution> filterGlobal(List<Offer_Task_Solution> listToFilter, String
	 * location, String type, String categorie) { List<Offer_Task_Solution> retour = new
	 * ArrayList(); System.out.println("we are in the filter..."); if (location !=
	 * "" && type == "" && categorie == "") {
	 * 
	 * for (Offer_Task_Solution offer : listToFilter) { if
	 * (offer.getLocation().toString().equals(location)) { retour.add(offer); } } }
	 * if (location == "" && type != "" && categorie == "") {
	 * System.out.println("we are in the filterBy Type it's working...");
	 * System.out.println(type);
	 * 
	 * for (Offer_Task_Solution offer : listToFilter) { System.out.println(offer);
	 * System.out.println(offer.getType().toString().equals(type));
	 * System.out.println(offer.getType()); if
	 * (offer.getType().toString().equals(type)) { System.out.println(offer);
	 * retour.add(offer); System.out.println(retour); } }
	 * System.out.println(retour);
	 * 
	 * } if (location == "" && type == "" && categorie != "") { for (Offer_Task_Solution offer :
	 * listToFilter) { if (offer.getCategorie().toString().equals(categorie)) {
	 * retour.add(offer); } } } if (location != "" && type != "" && categorie == "")
	 * { for (Offer_Task_Solution offer : listToFilter) { if
	 * (offer.getType().toString().equals(type) &&
	 * offer.getLocation().toString().equals(location)) { retour.add(offer); } } }
	 * if (location != "" && type == "" && categorie != "") { for (Offer_Task_Solution offer :
	 * listToFilter) { if (offer.getCategorie().toString().equals(categorie) &&
	 * offer.getLocation().toString().equals(location)) { retour.add(offer); } } }
	 * if (location == "" && type != "" && categorie != "") { for (Offer_Task_Solution offer :
	 * listToFilter) { if (offer.getType().toString().equals(type) &&
	 * offer.getCategorie().toString().equals(categorie)) { retour.add(offer); } } }
	 * if (location != "" && type != "" && categorie != "") { for (Offer_Task_Solution offer :
	 * listToFilter) { if (offer.getType().toString().equals(type) &&
	 * offer.getCategorie().toString().equals(categorie) &&
	 * offer.getLocation().toString().equals(location)) { retour.add(offer); } } }
	 * return retour; }
	 */
}
