package com.sip.ams.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name="jaime")
public class Like extends AuditModel {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
    private Long id;
	
	 @Column(name = "content")
	    private String content;
	    
	
	  @ManyToOne(fetch = FetchType.LAZY, optional = false)	  
	  @JoinColumn(name = "id_profile", nullable = false) // clé étrangère
	  @OnDelete(action = OnDeleteAction.CASCADE) 
	  private Profile profile;
	  
	  @ManyToOne(fetch = FetchType.LAZY, optional = false)	  
	  @JoinColumn(name = "id_generale_post", nullable = false) // clé étrangère
	  @OnDelete(action = OnDeleteAction.CASCADE) 
	  private General_Post generalpost;
	
	 
	    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public General_Post getGeneralpost() {
		return generalpost;
	}

	public void setGeneralpost(General_Post generalpost) {
		this.generalpost = generalpost;
	}

	

	
	
	 
	 
}
