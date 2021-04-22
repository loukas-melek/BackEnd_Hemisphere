package com.sip.ams.implementservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Sprint;
import com.sip.ams.entities.Sprint_Tasks;
import com.sip.ams.repositories.Sprint_TasksRepository;
import com.sip.ams.services.Sprint_Tasks_Service;

@Service
public class Sprint_TasksServiceImp implements Sprint_Tasks_Service {
	@Autowired
	Sprint_TasksRepository sprint_tasksRepository;
	
	@Override
	public List<Sprint_Tasks> getAllSprint_Tasks() {
		List<Sprint_Tasks> spr = new ArrayList<>();
		sprint_tasksRepository.findAll().forEach(spr::add);
        return spr;
	}

	@Override
	public Sprint_Tasks getSprint_TaskstById(long task_id) {
		return  sprint_tasksRepository.findById(task_id).get();
	}

	@Override
	public Sprint_Tasks insert(Sprint_Tasks sprint_tasks) {
		return sprint_tasksRepository.save(sprint_tasks);
	}

	@Override
	public void saveOrUpdate(Sprint_Tasks sprint_tasks, long task_id) {
		Sprint_Tasks sp=sprint_tasksRepository.findById(task_id).get();
		System.out.println(sp.toString());
		sp.setDescription(sp.getDescription());
		sp.setDuration(sp.getDuration());
		sp.setIs_done(sp.getIs_done());
		sp.setPriority(sp.getPriority());
		sp.setTask_type(sp.getTask_type());
		sprint_tasksRepository.save(sprint_tasks);
		
	}

	@Override
	public void delete(long task_id) {
		sprint_tasksRepository.deleteById(task_id);
		
	}

}
