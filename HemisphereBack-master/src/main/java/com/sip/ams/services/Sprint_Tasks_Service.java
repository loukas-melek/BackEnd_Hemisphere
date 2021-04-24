package com.sip.ams.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Sprint;
import com.sip.ams.entities.Sprint_Tasks;

@Service
public interface Sprint_Tasks_Service {
	
	List<Sprint_Tasks> getAllSprint_Tasks();
	
	Sprint_Tasks getSprint_TaskstById(long task_id);
	
	Sprint_Tasks insert(Sprint_Tasks sprint_tasks);
	void saveOrUpdate(Sprint_Tasks sprint_tasks,long task_id);
	void delete(long task_id);
	public List<Sprint_Tasks> getTasksbySprint(Long user_id);
}
