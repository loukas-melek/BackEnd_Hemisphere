package com.sip.ams.entities;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Application extends AuditModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_demande")
	private Long id;

	@Column(name = "motivation")
	private String motivation;

	@Column(name = "bidprice")
	private int bidprice;

	@Column(name = "deliverytime")
	private String deliverytime;
	
	@Column(name = "isvalide")
	private boolean isvalide;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_profile", nullable = true) // clé étrangère
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Profile profile;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "offer_task_solution_id", nullable = true) // clé étrangère
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Offer_Task_Solution offer_Task_Solution;

	public int getBidprice() {
		return bidprice;
	}

	public void setBidprice(int bidprice) {
		this.bidprice = bidprice;
	}

	public String getDeliverytime() {
		return deliverytime;
	}

	public void setDeliverytime(String deliverytime) {
		this.deliverytime = deliverytime;
	}

	

	public Offer_Task_Solution getOffer_Task_Solution() {
		return offer_Task_Solution;
	}

	public void setOffer_Task_Solution(Offer_Task_Solution offer_Task_Solution) {
		this.offer_Task_Solution = offer_Task_Solution;
	}

	public String getMotivation() {
		return motivation;
	}

	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
