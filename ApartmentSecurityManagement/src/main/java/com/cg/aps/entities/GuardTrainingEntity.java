package com.cg.aps.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GuardTraining")
public class GuardTrainingEntity extends BaseEntity{

	

	public GuardTrainingEntity(long id, String createdBy, String modifiedBy, LocalDateTime  createdDateTime,
			LocalDateTime  modifiedDateTime, long userId, String name, String mobileNo, String status, String timing,
			Date date) {
		super(id, createdBy, modifiedBy, createdDateTime, modifiedDateTime);
		this.userId = userId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.status = status;
		this.timing = timing;
		this.date = date;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	private String name;
	private String mobileNo;
	private String status;
	private String timing;
	
	private Date date;
	
/**
 * 
 */
public GuardTrainingEntity() {
	// TODO Auto-generated constructor stub
}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTiming() {
		return timing;
	}
	public void setTiming(String timing) {
		this.timing = timing;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "GuardTrainingEntity [userId=" + userId + ", name=" + name + ", mobileNo=" + mobileNo + ", status="
				+ status + ", timing=" + timing + ", date=" + date + "]";
	}
}
