package com.sip.ams.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


import com.sip.ams.entities.Competance;
import com.sip.ams.entities.Offer_Task_Solution;


@Service
public interface CompetenceService {
	List<Competance> listerCompetances();
	void addCompetance(Competance Competance,Long id);
	Competance updateCompetance(Long id,Competance Competance);
	void deleteCompetance(Long id);
	public List<Competance> getCompetanceByOfferId(Long id);
	public List<Offer_Task_Solution> getOfferByCompetanceId(Long id);
	public Competance getCompetanceByID(Long id);
	public List<Competance> getListCompetance(Long id);

}
