package com.sip.ams.converts;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.sip.ams.dto.ProjectDto;
import com.sip.ams.dto.SprintDto;
import com.sip.ams.dto.TasksDto;
import com.sip.ams.entities.Project;
import com.sip.ams.entities.Sprint;
import com.sip.ams.entities.Sprint_Tasks;
import com.sip.ams.entities.Task;

@Component
public class ProjectConverter {
	public TasksDto convertTaskToDto(Sprint_Tasks task) {
		ModelMapper mapper = new ModelMapper();
		TasksDto map = mapper.map(task, TasksDto.class);
		return map;
	}
	
	public SprintDto convertSprintToDto(Sprint sprint) {
//		ModelMapper mapper = new ModelMapper();
//		SprintDto map = mapper.map(sprint, SprintDto.class);
//		return map;
		SprintDto dto = new SprintDto();
		dto.setSprint_id(sprint.getSprint_id());
		dto.setStart_date(sprint.getStart_date());
		dto.setEnd_date(sprint.getEnd_date());
		dto.setSprint_type(sprint.getSprint_type());
		dto.setDescription(sprint.getDescription());
		
		dto.setSprintsTask(sprint.getSprintTasks().stream().map(x->convertTaskToDto(x)).collect(Collectors.toList()));
		return dto;
	}
	
	public ProjectDto convertProjectToDto(Project project) {
//		ModelMapper mapper = new ModelMapper();
//		ProjectDto map = mapper.map(project, ProjectDto.class);
//		return map;
		ProjectDto dto = new ProjectDto();
		dto.setProject_id(project.getProject_id());
		dto.setDescription(project.getDescription());
		dto.setStart_date(project.getStart_date());
		dto.setEnd_date(project.getEnd_date());
		dto.setTitle(project.getTitle());
		dto.setIs_active(project.getIs_active());
		//dto.setProject_category(project.getProject_category());
		dto.setSprints(project.getSprints().stream().map(x->convertSprintToDto(x)).collect(Collectors.toList()));
	return dto;
	}
	public List<ProjectDto> convertListProjectToDto(List<Project> projects){
		return projects.stream().map(x-> convertProjectToDto(x)).collect(Collectors.toList());
	}
	public List<SprintDto> convertListSprintToDto(List<Sprint> sprints){
		return sprints.stream().map(x-> convertSprintToDto(x)).collect(Collectors.toList());
	}
}
