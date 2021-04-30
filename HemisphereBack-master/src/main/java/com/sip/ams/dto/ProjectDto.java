package com.sip.ams.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.sip.ams.entities.CategorieOffer;
import com.sip.ams.entities.Profile;
import com.sip.ams.entities.Sprint;

public class ProjectDto {
	
	private Long project_id;

	
	private LocalDateTime start_date ;
	
	
	private LocalDateTime end_date ;
	
	private String title ;
	
	
	private  Integer is_active ;
	
	private  String description ;
	

	
	private CategorieOffer project_category ;
	
	//@JsonBackReference
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "profile_id", nullable = false)
//    private Profile profile;
  private Collection<SprintDto> sprints;
  





public Long getProject_id() {
	return project_id;
}

public void setProject_id(Long project_id) {
	this.project_id = project_id;
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

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}


public Integer getIs_active() {
	return is_active;
}

public void setIs_active(Integer is_active) {
	this.is_active = is_active;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}


public CategorieOffer getProject_category() {
	return project_category;
}

public void setProject_category(CategorieOffer project_category) {
	this.project_category = project_category;
}

public Collection<SprintDto> getSprints() {
	return sprints;
}

public void setSprints(Collection<SprintDto> sprints) {
	this.sprints = sprints;
}
  

}
