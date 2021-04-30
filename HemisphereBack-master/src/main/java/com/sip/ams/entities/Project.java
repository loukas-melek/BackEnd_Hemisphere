package com.sip.ams.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@Entity
@Table(name="Project")
public class Project extends AuditModel{
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long project_id;
	
		@Column(nullable = true)
		private LocalDateTime start_date ;
		
		@Column(nullable = true)
		private LocalDateTime end_date ;
		
		@Column(nullable = true)
		private String title ;
		
		@Column(nullable = true)
		private  Integer is_active ;
		
		@Column(nullable = true)
		private  String description ;
		
		 @ManyToOne(fetch = FetchType.LAZY, optional = false)	  
		  @JoinColumn(name = "id_generale_post", nullable = false) // clé étrangère
		  @OnDelete(action = OnDeleteAction.CASCADE) 
		  private General_Post generalpost;
		
		@Column(nullable = true)
		private CategorieOffer project_category ;
		
		//@JsonBackReference
		@ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "profile_id", nullable = false)
	    private Profile profile;

		 @ManyToMany
		 @JoinTable(
		name="Student_Project",
		joinColumns=@JoinColumn(name="PROJ_ID"
		,referencedColumnName="project_id"))
		private List<Profile> students;
		 
	  @OneToMany(mappedBy="project", cascade = CascadeType.ALL, orphanRemoval = true)
	  private Collection<Sprint> sprints;
	 
	
		
		
		

	
		

		public General_Post getGeneralpost() {
		return generalpost;
	}



	public void setGeneralpost(General_Post generalpost) {
		this.generalpost = generalpost;
	}



	public List<Profile> getStudents() {
		return students;
	}



	public void setStudents(List<Profile> students) {
		this.students = students;
	}



		public Project(){}
		
		

		public Project(Long project_id, LocalDateTime start_date, LocalDateTime end_date, String title,
				String image_path, Integer is_active, String description, Integer project_category_id,
				CategorieOffer project_category, Profile profile, List<Sprint> sprints) {
			super();
			this.project_id = project_id;
			this.start_date = start_date;
			this.end_date = end_date;
			this.title = title;
			this.is_active = is_active;
			this.description = description;
			this.project_category = project_category;
			this.profile = profile;
			this.sprints = sprints;
		}



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

		public Profile getProfile() {
			return profile;
		}

		public void setProfile(Profile profile) {
			this.profile = profile;
		}

		@Override
		public String toString() {
			return "Project [project_id=" + project_id + ", start_date=" + start_date + ", end_date=" + end_date
					+ ", title=" + title   + ", is_active=" + is_active + ", description="
					+ description + ", project_category_id="  + ", project_category="
					+ project_category + ", profile=" + profile + "]";
		}

		public Collection<Sprint> getSprints() {
			return sprints;
		}

		public void setSprints(Collection<Sprint> sprints) {
			this.sprints = sprints;
		}
		
		
			
		
		


}
