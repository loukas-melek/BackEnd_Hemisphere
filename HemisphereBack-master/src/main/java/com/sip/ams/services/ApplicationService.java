package com.sip.ams.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Application;


@Service
public interface ApplicationService {
	List<Application> listerDemande();
	void addDemande(Application demande);
	Application updateDemande(long id,Application demande);
	void deleteDemande(long id);
	public List<Application> getDemandeByUserId(Long user_id);
	public List<Application> getDemandeByOfferId(Long offer_id);
	public List<Application> getDemandeByTaskId(Long task_id);
}
