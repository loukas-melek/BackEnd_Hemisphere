package com.sip.ams.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Experience  extends AuditModel {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;	

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_profile", nullable = true) // clé étrangère
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Profile profile;
	
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private TypeOffer type;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public TypeOffer getType() {
		return type;
	}

	public void setType(TypeOffer type) {
		this.type = type;
	}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
