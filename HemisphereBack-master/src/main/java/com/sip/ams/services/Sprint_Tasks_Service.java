package com.sip.ams.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.sip.ams.dto.TasksDto;
import com.sip.ams.entities.Sprint;
import com.sip.ams.entities.Sprint_Tasks;

@Service
public interface Sprint_Tasks_Service {
	
	List<TasksDto> getAllSprint_Tasks();
	Sprint_Tasks getSprint_TaskstById(Long task_id);
	Sprint_Tasks insert(Sprint_Tasks sprint_tasks);
	void saveOrUpdate(Sprint_Tasks sprint_tasks,Long task_id);
	void delete(Long task_id);
	public List<Sprint_Tasks> getTasksbySprint(Long user_id);
}
