package com.sip.ams.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"start_date", "end_date"},
        allowGetters = true
)
public class Dates implements Serializable {
	 @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "start_date", nullable = true, updatable = false)
	    @CreatedDate
	    private Date start_date;

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "end_date", nullable = true)
	    @LastModifiedDate
	    private Date end_date;

		public Date getStart_date() {
			return start_date;
		}

		public void setStart_date(Date start_date) {
			this.start_date = start_date;
		}

		public Date getEnd_date() {
			return end_date;
		}

		public void setEnd_date(Date end_date) {
			this.end_date = end_date;
		}
	    
	    
}
