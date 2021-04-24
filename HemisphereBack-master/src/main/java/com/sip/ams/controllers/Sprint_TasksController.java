package com.sip.ams.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sip.ams.entities.Sprint_Tasks;
import com.sip.ams.services.Sprint_Tasks_Service;

@RestController  
@RequestMapping("/sprint_tasks")
public class Sprint_TasksController {
	@Autowired
	Sprint_Tasks_Service sprint_tasks_service;
	
	@GetMapping
	public ResponseEntity<List<Sprint_Tasks>> getAllSprint_Tasks()
	{  
	List<Sprint_Tasks> pro = sprint_tasks_service.getAllSprint_Tasks();
	return new ResponseEntity<>(pro, HttpStatus.OK); 
	} 
	
	@GetMapping("/{task_id}")  
	public ResponseEntity<Sprint_Tasks> getSprint_TasksById(@PathVariable Long task_id) 
	{
        return new ResponseEntity<>(sprint_tasks_service.getSprint_TaskstById(task_id), HttpStatus.OK);
	}
	@GetMapping("task/{sprint_id}")  
	public List<Sprint_Tasks> getTasksBysprintId(@PathVariable Long sprint_id) 
	{
        return sprint_tasks_service.getTasksbySprint(sprint_id);
	}
	@DeleteMapping("/{task_id}")  
	public ResponseEntity<Sprint_Tasks> delete(@PathVariable("task_id") Long task_id) 
	{
		sprint_tasks_service.delete(task_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping
	public ResponseEntity<Sprint_Tasks> saveproject(@RequestBody Sprint_Tasks sprint_tasks) {
		Sprint_Tasks sprint_tasks1 = sprint_tasks_service.insert(sprint_tasks);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("sprint_tasks", "/sprint_tasks/" + sprint_tasks1.getTask_id().toString());
        return new ResponseEntity<>(sprint_tasks1, httpHeaders, HttpStatus.CREATED);
    }
	
	@PutMapping("/{task_id}")  		
	public ResponseEntity<Sprint_Tasks> saveOrUpdate(@PathVariable("task_id") long task_id, @RequestBody Sprint_Tasks sprint_tasks) {
		sprint_tasks_service.saveOrUpdate(sprint_tasks,task_id);
        return new ResponseEntity<>(sprint_tasks_service.getSprint_TaskstById(task_id), HttpStatus.OK);
    }
}
