package com.sip.ams.implementservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.converts.ProjectConverter;
import com.sip.ams.dto.ProjectDto;
import com.sip.ams.entities.Project;
import com.sip.ams.repositories.ProfileRepository;
import com.sip.ams.repositories.ProjectRepository;
import com.sip.ams.services.ProjectService;

@Service
public class ProjectServiceImp implements ProjectService{
	@Autowired  
	ProjectRepository projectrepository;
	@Autowired  
	ProfileRepository profilerepository;
	
	@Autowired
	private ProjectConverter converter;
	
	@Override
	public List<ProjectDto> getAllProjects() {
		List<Project> pro = new ArrayList<>();
		pro = projectrepository.findAll();
        return converter.convertListProjectToDto(pro);
	}

	@Override
	public Project getProjectById(long project_id) {
		return  projectrepository.findById(project_id).get(); 
	}
	
	@Override
    public Project insert(Project project) {
        return projectrepository.save(project);
    }

	@Override
	public void saveOrUpdate(Project project,long project_id) {
		Project projec=projectrepository.findById(project_id).get();
		System.out.println(projec.toString());
		projec.setCreated_at(project.getCreated_at());
		projec.setDescription(project.getDescription());
		projec.setEnd_date(project.getEnd_date());
		projec.setImage_path(project.getImage_path());
		projec.setIs_active(project.getIs_active());
		projec.setProject_category_id(project.getProject_category_id());
		projec.setStart_date(project.getStart_date());
		projec.setTitle(project.getTitle());
		projec.setUpdated_at(projec.getUpdated_at());
		project.setProfile(project.getProfile());
		 projectrepository.save(project);
	}

	
	@Override
	public void delete(long project_id) {
		projectrepository.deleteById(project_id);
	}

}
