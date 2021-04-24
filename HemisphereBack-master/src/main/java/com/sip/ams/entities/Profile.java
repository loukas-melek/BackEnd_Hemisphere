package com.sip.ams.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "profile")
public class Profile extends AuditModel {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;
		
		@Column(name = "about")
		private String about;
		
		@Column(name = "name")
	    private String name;
		
		@Column(name = "lastname")
	    private String lastname;
		
		@Column(name = "phone")
	    private String phone;
		
		@Column(name = "city")
	    private String city;
		
		@Column(name = "profilePicUrl")
	    private String profilePicUrl;	
		
		@Column(name = "gender")
	    private boolean gender;
		
		@Column(name = "location")
	    private String location;
		
		@Column(name = "email")
	    private String email;

		@Column(name = "interests")
	    private String interests;
		
		@Column(name = "languages")
	    private String languages;

		@Column(name = "state")
	    private String state;
		
		@JsonBackReference
		@OneToOne(fetch = FetchType.LAZY, optional = false)
		@JoinColumn(name = "user_id", nullable = false)
		private User user;
		
		

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getAbout() {
			return about;
		}

		public void setAbout(String about) {
			this.about = about;
		}

		public String getProfilePicUrl() {
			return profilePicUrl;
		}

		public void setProfilePicUrl(String profilePicUrl) {
			this.profilePicUrl = profilePicUrl;
		}

		public boolean isGender() {
			return gender;
		}

		public void setGender(boolean gender) {
			this.gender = gender;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getInterests() {
			return interests;
		}

		public void setInterests(String interests) {
			this.interests = interests;
		}

		public String getLanguages() {
			return languages;
		}

		public void setLanguages(String languages) {
			this.languages = languages;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		

}
