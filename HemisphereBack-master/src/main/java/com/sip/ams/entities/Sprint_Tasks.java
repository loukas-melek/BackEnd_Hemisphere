package com.sip.ams.entities;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="Sprint_Tasks")
public class Sprint_Tasks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long task_id;
	
	@Column(nullable = true)
	private Integer task_type ;
	
	@Column(nullable = true)
	private Integer is_done ;
	
	@Column(name = "task_status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(nullable = true)
	private Integer priority ;
	
	@Column(nullable = true)
	private double duration ;
	
	@Column(nullable = true)
	private  String description ;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_sprint", nullable = true) // clé étrangère
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Sprint sprint;
	/*
	 * @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
	 * CascadeType.MERGE }, mappedBy = "tasks") private Set<Sprint> sprints = new
	 * HashSet<>();
	 */
	
	
	public Sprint_Tasks() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Sprint getSprint() {
		return sprint;
	}



	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}



	public Sprint_Tasks(Long task_id, Integer task_type, Integer is_done, Integer priority, double duration,
			String description, Sprint sprint) {
		super();
		this.task_id = task_id;
		this.task_type = task_type;
		this.is_done = is_done;
		this.priority = priority;
		this.duration = duration;
		this.description = description;
	}

	public void setTask_id(Long task_id) {
		this.task_id = task_id;
	}

	public Integer getTask_type() {
		return task_type;
	}

	public void setTask_type(Integer task_type) {
		this.task_type = task_type;
	}

	
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getIs_done() {
		return is_done;
	}

	public void setIs_done(Integer is_done) {
		this.is_done = is_done;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Long getTask_id() {
		return task_id;
	}


	
	

}

