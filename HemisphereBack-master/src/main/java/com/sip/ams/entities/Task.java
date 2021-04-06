package com.sip.ams.entities;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "cost")
	private int cost;

	@Column(name = "isSupervised")
	private int isSupervised;
	
	@ManyToMany(cascade = CascadeType.ALL)
	  @JoinTable(name = "task_competance", joinColumns = @JoinColumn(name = "task_id"),
	  inverseJoinColumns = @JoinColumn(name = "competance_id")) 
	  private Set<Competance> competance;
	
	@Column(name = "date")
	private Date date;
	
	
	
	@Column(name = "CATEGORIE")
	@Enumerated(EnumType.STRING)
	private CategorieOffer categorie;
	
	@Column(name = "location")
	@Enumerated(EnumType.STRING)
	private LocationsOffer location;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}



	public CategorieOffer getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieOffer categorie) {
		this.categorie = categorie;
	}

	public LocationsOffer getLocation() {
		return location;
	}

	public void setLocation(LocationsOffer location) {
		this.location = location;
	}

	public Set<Competance> getCompetance() {
		return competance;
	}

	public void setCompetance(Set<Competance> competance) {
		this.competance = competance;
	}

	public int getIsSupervised() {
		return isSupervised;
	}

	public void setIsSupervised(int isSupervised) {
		this.isSupervised = isSupervised;
	}
	
	
}
