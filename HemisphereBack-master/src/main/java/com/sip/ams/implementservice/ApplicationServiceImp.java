package com.sip.ams.implementservice;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Application;
import com.sip.ams.repositories.ApplicationRepository;
import com.sip.ams.services.ApplicationService;
@Service
public class ApplicationServiceImp implements ApplicationService {
	@Autowired
	private ApplicationRepository applicationRepository;

	@Override
	public List<Application> listerDemande() {

		return applicationRepository.findAll();
	}

	@Override
	public void addDemande(Application demande) {
		/*
		 * System.out.println(demande.getUser()); Application d = new Application();
		 * d.setBidprice(demande.getBidprice());
		 * d.setDeliverytime(demande.getDeliverytime()); d.setTask(demande.getTask());
		 * d.setOffer(demande.getOffer()); d.setUser(demande.getUser());
		 * d.setDate(demande.getDate()); d.setMotivation(demande.getMotivation());
		 */
		System.out.println(demande.getMotivation());
		demande.setCreated_at(new Date());
		demande.setUpdated_at(new Date());
		applicationRepository.save(demande);

	}

	@Override
	public Application updateDemande(long id, Application demande) {

		Application oldDemande = applicationRepository.findDemandeById(id);
		if (oldDemande != null) {
			oldDemande.setProfile(demande.getProfile());
			oldDemande.setCreated_at(demande.getCreated_at());
			oldDemande.setUpdated_at(demande.getUpdated_at());
			oldDemande.setMotivation(demande.getMotivation());
			oldDemande.setOffer_Task_Solution(demande.getOffer_Task_Solution());
			oldDemande.setBidprice(demande.getBidprice());
			oldDemande.setDeliverytime(demande.getDeliverytime());
			applicationRepository.save(oldDemande);
		}
		return oldDemande;
	}

	@Override
	public void deleteDemande(long id) {
		applicationRepository.deleteById(id);

	}

	@Override
	public List<Application> getDemandeByUserId(Long user_id) {

		return applicationRepository.getDemandeByUserId(user_id);
	}

	@Override
	public List<Application> getDemandeByOfferId(Long offer_id) {

		return applicationRepository.getDemandeByOfferId(offer_id);
	}

	


}
