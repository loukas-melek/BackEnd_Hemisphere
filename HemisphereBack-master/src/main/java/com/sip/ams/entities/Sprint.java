package com.sip.ams.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Sprint")
public class Sprint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sprint_id;
	
	@Column(nullable = true)
	private LocalDateTime start_date ;
	
	@Column(nullable = true)
	private LocalDateTime end_date ;
	
	@Column(nullable = true)
	private Integer sprint_type ;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
   // @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    private Project project;
	
	@Column(nullable = true)
	private String description ;
	
	public Sprint(){}
	
	public Sprint(Long sprint_id, LocalDateTime start_date, LocalDateTime end_date, Integer sprint_type,
			Project project, String description) {
		super();
		this.sprint_id = sprint_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.sprint_type = sprint_type;
		this.project = project;
		this.description = description;
	}

	public Long getSprint_id() {
		return sprint_id;
	}

	public void setSprint_id(Long sprint_id) {
		this.sprint_id = sprint_id;
	}

	public LocalDateTime getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDateTime start_date) {
		this.start_date = start_date;
	}

	public LocalDateTime getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDateTime end_date) {
		this.end_date = end_date;
	}

	public Integer getSprint_type() {
		return sprint_type;
	}

	public void setSprint_type(Integer sprint_type) {
		this.sprint_type = sprint_type;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Sprint [sprint_id=" + sprint_id + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", sprint_type=" + sprint_type + ", project=" + project + ", description=" + description + "]";
	}
	
	
	
	
	

	
	
	

}
