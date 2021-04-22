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

import com.sip.ams.entities.Project;
import com.sip.ams.services.ProjectService;

@RestController  
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectService projectservice;
	
	
	@GetMapping
	public ResponseEntity<List<Project>> getAllProjects()   
	{  
	List<Project> pro = projectservice.getAllProjects();
	return new ResponseEntity<>(pro, HttpStatus.OK); 
	} 
	
	
	@GetMapping("/{project_id}")  
	public ResponseEntity<Project> getProjectById(@PathVariable Long project_id) 
	{
        return new ResponseEntity<>(projectservice.getProjectById(project_id), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{project_id}")  
	public ResponseEntity<Project> delete(@PathVariable("project_id") Long project_id) 
	{
		projectservice.delete(project_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	@PostMapping
	public ResponseEntity<Project> saveproject(@RequestBody Project project) {
        Project Project1 = projectservice.insert(project);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("project", "/project/" + Project1.getProject_id().toString());
        return new ResponseEntity<>(Project1, httpHeaders, HttpStatus.CREATED);
    }
	
	@PutMapping("/{project_id}")  		
	public ResponseEntity<Project> saveOrUpdate(@PathVariable("project_id") long project_id, @RequestBody Project project) {
		projectservice.saveOrUpdate(project,project_id);
        return new ResponseEntity<>(projectservice.getProjectById(project_id), HttpStatus.OK);
    }

}
