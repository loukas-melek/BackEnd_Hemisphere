package com.sip.ams.entities;

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
public class FriendList {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	/*
	 * @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 * 
	 * @JoinColumn(name = "user_id", nullable = false) // clé étrangère
	 * 
	 * @OnDelete(action = OnDeleteAction.CASCADE) private User user;
	 */
    

}
