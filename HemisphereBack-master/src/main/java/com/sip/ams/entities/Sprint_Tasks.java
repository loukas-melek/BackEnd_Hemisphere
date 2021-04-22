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
	
	@Column(nullable = true)
	private Integer priority ;
	
	@Column(nullable = true)
	private double duration ;
	
	@Column(nullable = true)
	private  String description ;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name ="sprint_id",nullable = false)
    private Sprint sprint;

	
	public Sprint_Tasks() {
		super();
		// TODO Auto-generated constructor stub
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
		this.sprint = sprint;
	}

	public Long getTask_id() {
		return task_id;
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

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	@Override
	public String toString() {
		return "Sprint_Tasks [task_id=" + task_id + ", task_type=" + task_type + ", is_done=" + is_done + ", priority="
				+ priority + ", duration=" + duration + ", description=" + description + ", sprint=" + sprint + "]";
	}

}

