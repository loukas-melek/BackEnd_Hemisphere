package com.sip.ams.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CompetenceOfOffers implements Serializable {

    @Column(name = "offer_id")
	private Long offer_id;
	
    @Column(name = "competence_id")

	private Long competence_id;

	public Long getOffer_id() {
		return offer_id;
	}

	public void setOffer_id(Long offer_id) {
		this.offer_id = offer_id;
	}

	public Long getCompetence_id() {
		return competence_id;
	}

	public void setCompetence_id(Long competence_id) {
		this.competence_id = competence_id;
	}

	public CompetenceOfOffers(Long offer_id, Long competence_id) {
		super();
		this.offer_id = offer_id;
		this.competence_id = competence_id;
	}

	public CompetenceOfOffers() {
		super();
	}
    
    
	
}
