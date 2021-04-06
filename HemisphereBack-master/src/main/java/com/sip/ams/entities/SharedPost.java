package com.sip.ams.entities;

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



@Entity
public class SharedPost {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
    private Long id;
	
	 
	 
	 	@ManyToOne(fetch = FetchType.LAZY, optional = false)
		@JoinColumn(name = "id_pub", nullable = false) // clé étrangère
		@OnDelete(action = OnDeleteAction.CASCADE)
		private General_Post general_Post;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public General_Post getPub() {
		return general_Post;
	}

	public void setPub(General_Post general_Post) {
		this.general_Post = general_Post;
	}

	
	 
}
