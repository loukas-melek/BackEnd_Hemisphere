package com.sip.ams.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "content")
	private String content;

	@Column(name = "media_path")
	private String media_path;

	public Long getId() {
		return id;
	}

	

	public String getMedia_path() {
		return media_path;
	}



	public void setMedia_path(String media_path) {
		this.media_path = media_path;
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

}
