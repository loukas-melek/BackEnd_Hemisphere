package com.sip.ams.implementservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Competance;
import com.sip.ams.entities.Offer_Task_Solution;
import com.sip.ams.repositories.CompetanceRepository;
import com.sip.ams.services.CompetenceService;

@Service
public class CompetanceServiceImp implements CompetenceService {
	@Autowired
	private CompetanceRepository competanceRepository;
	@Override
	public List<Competance> listerCompetances() {
		// TODO Auto-generated method stub
		return competanceRepository.findAll();
	}

	@Override
	public void addCompetance(Competance Competance,Long id) {
		// TODO Auto-generated method stub
		Competance c=competanceRepository.save(Competance);
		System.out.println("id el task"+id);
		System.out.println(Competance.getId());
		System.out.println(Competance.getCompetance());
		competanceRepository.addCompetanceToOffertask(id, c.getId());
		
		
	}

	@Override
	public Competance updateCompetance(Long id, Competance Competance) {
		Competance oldComp=competanceRepository.getOne(id);
		if(oldComp!=null) {
			oldComp.setCompetance(Competance.getCompetance());
			
			competanceRepository.save(oldComp);
		}
		return oldComp;
	}

	@Override
	public void deleteCompetance(Long id) {
		// TODO Auto-generated method stub
		competanceRepository.deleteById(id);
	}

	@Override
	public List<Competance> getCompetanceByOfferId(Long id) {
		// TODO Auto-generated method stub
		return competanceRepository.getCompetanceByOfferId(id);
	}

	@Override
	public List<Offer_Task_Solution> getOfferByCompetanceId(Long id) {
		// TODO Auto-generated method stub
		return competanceRepository.getOfferByCompetanceId(id);
	}

	@Override
	public Competance getCompetanceByID(Long id) {
		// TODO Auto-generated method stub
		return competanceRepository.getOne(id);
	}

	@Override
	public List<Competance> getListCompetance(Long id) {
		// TODO Auto-generated method stub
		
		List<Long> lst = competanceRepository.getListCompetance(id);
		System.out.println(id+"our list here"+lst);
		List<Competance> retour = new ArrayList<Competance>();
		for(int i=0;i<lst.size();i++) {
			retour.add(competanceRepository.getOne(lst.get(i)));
			System.out.println(competanceRepository.getOne(lst.get(i)).getCompetance());
		}
		return retour;
	}

}
