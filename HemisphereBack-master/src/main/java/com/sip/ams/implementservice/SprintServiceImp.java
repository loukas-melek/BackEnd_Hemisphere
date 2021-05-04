package com.sip.ams.implementservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.converts.ProjectConverter;
import com.sip.ams.dto.SprintDto;
import com.sip.ams.entities.Project;
import com.sip.ams.entities.Sprint;
import com.sip.ams.repositories.ProjectRepository;
import com.sip.ams.repositories.SprintRepository;
import com.sip.ams.services.SprintService;

@Service
public class SprintServiceImp implements SprintService {
	@Autowired
	SprintRepository sprintrepository;
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	private ProjectConverter converter;
	@Override
	public List<Sprint> getAllSprints() {
		List<Sprint> spr = new ArrayList<>();
		sprintrepository.findAll().forEach(spr::add);
        return spr;
	}

	@Override
	public SprintDto getSprintById(Long sprint_id) {
		Sprint s=  sprintrepository.findById(sprint_id).get(); 
		return converter.convertSprintToDto(s);
	}

	@Override
    public Sprint insert(Sprint sprint) {
        Project sp=projectRepository.getOne(sprint.getProject().getProject_id());
        sprint.setProject(sp);
        System.out.println(sprint);
        return sprintrepository.save(sprint);
    }

	@Override
	public void saveOrUpdate(Sprint sprint, Long sprint_id) {
		Sprint sprin=sprintrepository.findById(sprint_id).get();
		System.out.println(sprin.toString());
		sprin.setDescription(sprin.getDescription());
		sprin.setEnd_date(sprin.getEnd_date());
		sprin.setStart_date(sprin.getStart_date());
		sprin.setSprint_type(sprin.getSprint_type());
		sprintrepository.save(sprint);
		
	}

	@Override
	public void delete(Long sprint_id) {
		sprintrepository.deleteById(sprint_id);
		
	}

	@Override
	public List<SprintDto> getSprintsByproject(Long project_id) {
		// TODO Auto-generated method stub
		List<Sprint> s= sprintrepository.getSprintsByproject(project_id);
		return converter.convertListSprintToDto(s);
	}

}
