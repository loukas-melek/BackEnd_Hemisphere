package com.sip.ams.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sip.ams.dto.SprintDto;
import com.sip.ams.entities.Project;
import com.sip.ams.entities.Sprint;
import com.sip.ams.entities.Sprint_Tasks;
import com.sip.ams.services.SprintService;

@RestController  
@RequestMapping("/sprint")
@CrossOrigin
public class SprintController {
	@Autowired
	SprintService sprintservice;
	
	@GetMapping	
	public ResponseEntity<List<Sprint>> getAllSprints()   
	{  
	List<Sprint> spr = sprintservice.getAllSprints();
	return new ResponseEntity<>(spr, HttpStatus.OK); 
	} 

	
	@GetMapping("/{sprint_id}")  
	public ResponseEntity<SprintDto> getSprintById(@PathVariable Long sprint_id) 
	{
        return new ResponseEntity<>(sprintservice.getSprintById(sprint_id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{sprint_id}")  
	public ResponseEntity<Project> delete(@PathVariable("sprint_id") Long sprint_id) 
	{
		sprintservice.delete(sprint_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("sprint/{project_id}")  
	public List<SprintDto> getTasksBysprintId(@PathVariable Long project_id) 
	{
        return sprintservice.getSprintsByproject(project_id);
	}
	
	@PostMapping
	public ResponseEntity<Sprint> saveproject(@RequestBody Sprint sprint) {
        Sprint sprint1 = sprintservice.insert(sprint);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("sprint", "/sprint/" + sprint1.getSprint_id().toString());
        return new ResponseEntity<>( httpHeaders, HttpStatus.CREATED);
    }
	
	@PutMapping("/{sprint_id}")  		
	public ResponseEntity<Sprint> saveOrUpdate(@PathVariable("sprint_id") Long sprint_id, @RequestBody Sprint sprint) {
		sprintservice.saveOrUpdate(sprint,sprint_id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
