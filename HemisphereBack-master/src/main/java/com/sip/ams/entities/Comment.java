package com.sip.ams.entities;

import java.sql.Date;

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
public class Comment extends AuditModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "content")
	private String content;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_profile", nullable = false) // clé étrangère
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Profile profile;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_general_post", nullable = true) // clé étrangère
	@OnDelete(action = OnDeleteAction.CASCADE)
	private General_Post general_Post;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_comment", nullable = true) // clé étrangère
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Comment id_comment;

	
	
	public Comment getId_comment() {
		return id_comment;
	}

	public void setId_comment(Comment id_comment) {
		this.id_comment = id_comment;
	}

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

	public General_Post getGeneral_Post() {
		return general_Post;
	}

	public void setGeneral_Post(General_Post general_Post) {
		this.general_Post = general_Post;
	}

}
