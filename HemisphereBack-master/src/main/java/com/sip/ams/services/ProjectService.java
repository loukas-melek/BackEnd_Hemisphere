package com.sip.ams.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.sip.ams.dto.ProjectDto;
import com.sip.ams.entities.Profile;
import com.sip.ams.entities.Project;

@Service
public interface ProjectService {
	
	List<ProjectDto> getAllProjects();
	Project getProjectById(Long project_id);
	Project insert(Project project);
	 void saveOrUpdate(Project project,Long project_id);
	 void delete(Long project_id);
	 void ConfirmProject( Long proj_id, List<Profile> students);
	 Project findByGeneralPostId( Long id );
	 List<Project> findByStudentId(Long id);

}
