package com.sip.ams.implementservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Project;
import com.sip.ams.entities.Sprint;
import com.sip.ams.repositories.SprintRepository;
import com.sip.ams.services.SprintService;

@Service
public class SprintServiceImp implements SprintService {
	@Autowired
	SprintRepository sprintrepository;
	
	@Override
	public List<Sprint> getAllSprints() {
		List<Sprint> spr = new ArrayList<>();
		sprintrepository.findAll().forEach(spr::add);
        return spr;
	}

	@Override
	public Sprint getSprintById(long sprint_id) {
		return  sprintrepository.findById(sprint_id).get(); 
	}

	@Override
	public Sprint insert(Sprint sprint) {
		return sprintrepository.save(sprint);
	}

	@Override
	public void saveOrUpdate(Sprint sprint, long sprint_id) {
		Sprint sprin=sprintrepository.findById(sprint_id).get();
		System.out.println(sprin.toString());
		sprin.setDescription(sprin.getDescription());
		sprin.setEnd_date(sprin.getEnd_date());
		sprin.setStart_date(sprin.getStart_date());
		sprin.setSprint_type(sprin.getSprint_type());
		sprintrepository.save(sprint);
		
	}

	@Override
	public void delete(long sprint_id) {
		sprintrepository.deleteById(sprint_id);
		
	}

}
