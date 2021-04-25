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
	
	@Column(name = "status")
	private int status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_profile", nullable = true) // clé étrangère
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Profile profile;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pub_id", nullable = true) // clé étrangère
	@OnDelete(action = OnDeleteAction.CASCADE)
	private General_Post generalpost;

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

	

	public General_Post getGeneralpost() {
		return generalpost;
	}

	public void setGeneralpost(General_Post generalpost) {
		this.generalpost = generalpost;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
