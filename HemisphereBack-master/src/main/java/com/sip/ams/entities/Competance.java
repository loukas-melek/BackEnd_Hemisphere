package com.sip.ams.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Competance {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Long id;
	
	@Column(name="competance")
	private String competance;
	
	/*
	 * @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 * 
	 * @JoinColumn(name = "id_offer", nullable = false) // clé étrangère
	 * 
	 * @OnDelete(action = OnDeleteAction.CASCADE) private Offer_Task_Solution offer;
	 */
	
	//@ManyToMany(mappedBy = "lstcompetence", fetch = FetchType.LAZY)
	//Offer_Task_Solution offer;

	

	public Competance(Long idCompetence, String competance) {
		super();
		this.id= idCompetence;
		this.competance = competance;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long idCompetence) {
		this.id = idCompetence;
	}

	
	public String getCompetance() {
		return competance;
	}

	public void setCompetance(String competance) {
		this.competance = competance;
	}


	public Competance() {
		super();
	}

	

	
	 
	 
	 
	 
	 
	 
	
	
	
}
