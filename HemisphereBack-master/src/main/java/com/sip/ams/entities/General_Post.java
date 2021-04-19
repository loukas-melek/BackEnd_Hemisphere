package com.sip.ams.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class General_Post extends AuditModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;	

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_profile", nullable = true) // clé étrangère
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Profile profile;

	@Column(name = "nlike")
	private int nlike;

	@Column(name = "ncomment")
	private int ncomment;

	@Column(name = "nshare")
	private int nshare;

	@Column(name = "affichedate")
	private String affichedate;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_comment", nullable = true, columnDefinition = "bigint default 0") // clé étrangère
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	private Comment comment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "offer_task_solution_id", nullable = true) // clé étrangère
	private Offer_Task_Solution offertasksolution;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_post", nullable = true, columnDefinition = "bigint default 0") // clé étrangère
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Post post;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_sharedpost", nullable = true) // clé étrangère
	@OnDelete(action = OnDeleteAction.CASCADE)
	private SharedPost sharedpost;

	public String getAffichedate() {
		return affichedate;
	}

	public void setAffichedate(String affichedate) {
		this.affichedate = affichedate;
	}

	public int getNcomment() {
		return ncomment;
	}

	public void setNcomment(int ncomment) {
		this.ncomment = ncomment;
	}



	public int getNshare() {
		return nshare;
	}

	public void setNshare(int nshare) {
		this.nshare = nshare;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public SharedPost getSharedpost() {
		return sharedpost;
	}

	public void setSharedpost(SharedPost sharedpost) {
		this.sharedpost = sharedpost;
	}

	

	public Offer_Task_Solution getOffertasksolution() {
		return offertasksolution;
	}

	public void setOffertasksolution(Offer_Task_Solution offertasksolution) {
		this.offertasksolution = offertasksolution;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public int getNlike() {
		return nlike;
	}

	public void setNlike(int nlike) {
		this.nlike = nlike;
	}

}
