package com.sip.ams.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sip.ams.entities.Project;

@Service
public interface ProjectService {
	
	List<Project> getAllProjects();
	Project getProjectById(long project_id);
	Project insert(Project project);
	 void saveOrUpdate(Project project,long project_id);
	 void delete(long project_id);
	
}
