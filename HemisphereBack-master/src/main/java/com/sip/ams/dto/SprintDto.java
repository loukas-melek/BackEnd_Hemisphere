package com.sip.ams.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.sip.ams.entities.Project;
import com.sip.ams.entities.Sprint_Tasks;
import com.sip.ams.entities.Status;

public class SprintDto {

   private Long sprint_id;
	
	private LocalDateTime  start_date ;
	
	private LocalDateTime  end_date ;
	
	private Integer sprint_type ;
	
	private Status status;
	private String description ;

	private List<TasksDto> sprintsTask;

	public Long getSprint_id() {
		return sprint_id;
	}

	public void setSprint_id(Long sprint_id) {
		this.sprint_id = sprint_id;
	}

	

	public LocalDateTime  getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDateTime  start_date) {
		this.start_date = start_date;
	}

	public LocalDateTime  getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDateTime  end_date) {
		this.end_date = end_date;
	}

	public Integer getSprint_type() {
		return sprint_type;
	}

	public void setSprint_type(Integer sprint_type) {
		this.sprint_type = sprint_type;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<TasksDto> getSprintsTask() {
		return sprintsTask;
	}

	public void setSprintsTask(List<TasksDto> sprintsTask) {
		this.sprintsTask = sprintsTask;
	}


	
	
	
}
