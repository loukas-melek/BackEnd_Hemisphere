package com.sip.ams.implementservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.converts.ProjectConverter;
import com.sip.ams.dto.TasksDto;
import com.sip.ams.entities.Sprint;
import com.sip.ams.entities.Sprint_Tasks;
import com.sip.ams.repositories.SprintRepository;
import com.sip.ams.repositories.Sprint_TasksRepository;
import com.sip.ams.services.Sprint_Tasks_Service;

@Service
public class Sprint_TasksServiceImp implements Sprint_Tasks_Service {
	@Autowired
	Sprint_TasksRepository sprint_tasksRepository;
	@Autowired
	SprintRepository sprintRepository;
	@Autowired
	private ProjectConverter converter;
	@Override
	public List<TasksDto> getAllSprint_Tasks() {
		List<TasksDto> retour=new ArrayList<TasksDto>();
		List<Sprint_Tasks> spr = new ArrayList<>();
		sprint_tasksRepository.findAll().forEach(spr::add);
		 for(int i=0;i<spr.size();i++) {
			retour.add(converter.convertTaskToDto(spr.get(i)));
		 }
        return retour;
	}

	@Override
	public Sprint_Tasks getSprint_TaskstById(Long task_id) {
		return  sprint_tasksRepository.findById(task_id).get();
	}

	@Override
	public Sprint_Tasks insert(Sprint_Tasks sprint_tasks) {
		return sprint_tasksRepository.save(sprint_tasks);
	}

	@Override
	public void saveOrUpdate(Sprint_Tasks sprint_tasks, Long task_id) {
		
		  Sprint_Tasks sp=sprint_tasksRepository.findById(task_id).get();
		  System.out.println(sp.getStatus());
		  System.out.println(sp.toString()); sp.setDescription(sp.getDescription());
		  sp.setDuration(sp.getDuration()); sp.setIs_done(sp.getIs_done());
		  sp.setPriority(sp.getPriority()); sp.setTask_type(sp.getTask_type()); Sprint
		  s=sprintRepository.getOne(sprint_tasks.getSprint().getSprint_id());
		  sp.setSprint(s); System.out.println(sp.getSprint().getSprint_id());
		  System.out.println(sp.getSprint().getDescription());
		  System.out.println(sp.getDescription());
		 sp.setStatus(sprint_tasks.getStatus());
		 System.out.println(sp.getStatus());
		sprint_tasksRepository.save(sp);
		System.out.println("ss");
	}

	@Override
	public void delete(Long task_id) {
		sprint_tasksRepository.deleteById(task_id);
		
	}

	@Override
	public List<Sprint_Tasks> getTasksbySprint(Long user_id) {
		// TODO Auto-generated method stub
		return sprint_tasksRepository.getTasksbySprint(user_id);
	}

}
