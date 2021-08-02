package com.sip.ams.entities;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Offer_Task_Solution {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "title")
	private String title;

	public int getType() {
		return type;
	}

	@Column(name = "description")
	private String description;

	@Column(name = "studentNumber")
	private int studentNumber;

	@Column(name = "isSupervised")
	private int isSupervised;

	@Column(name = "type")
	private int type;
	
	@Column(name = "offer_type")
	@Enumerated(EnumType.STRING)
	private TypeOffer offer_type;

	@Column(name = "cost")
	private int cost;
	
	@Column(name = "poste")
	private String poste;

	@Column(name = "image")
    private String image;	
	
	@Column(name = "CATEGORIE")
	@Enumerated(EnumType.STRING)
	private CategorieOffer categorie;

	@Column(name = "location")
	@Enumerated(EnumType.STRING)
	private LocationsOffer location;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "offertask_competance", joinColumns = @JoinColumn(name = "offertask_id"), inverseJoinColumns = @JoinColumn(name = "competance_id"))
	private Set<Competance> competance;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public int getIsSupervised() {
		return isSupervised;
	}

	public void setIsSupervised(int isSupervised) {
		this.isSupervised = isSupervised;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public TypeOffer getOffer_type() {
		return offer_type;
	}

	public void setOffer_type(TypeOffer offer_type) {
		this.offer_type = offer_type;
	}

	public void setType(int type) {
		this.type = type;
	}



	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public Set<Competance> getCompetance() {
		return competance;
	}

	public void setCompetance(Set<Competance> competance) {
		this.competance = competance;
	}

}
