package com.cg.aps.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Table;
/**
 * @author Aditya
 *
 */
@Entity
@Table(name="GuardTraining")
public class GuardTrainingEntity extends BaseEntity{

	

	
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	private String name;
	private String mobileNo;
	private String status;
	private String timing;
	
	private Date date;
	
	
	
	
/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}




	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}




	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}




	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}




	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}




	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}




	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}




	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}




	/**
	 * @return the timing
	 */
	public String getTiming() {
		return timing;
	}




	/**
	 * @param timing the timing to set
	 */
	public void setTiming(String timing) {
		this.timing = timing;
	}




	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}




	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	




 
/**
	 * @param id
	 * @param createdBy
	 * @param modifiedBy
	 * @param createdDateTime
	 * @param modifiedDateTime
	 * @param userId
	 * @param name
	 * @param mobileNo
	 * @param status
	 * @param timing
	 * @param date
	 */
	public GuardTrainingEntity(long id, String createdBy, String modifiedBy, LocalDateTime createdDateTime,
			LocalDateTime modifiedDateTime, long userId, String name, String mobileNo, String status, String timing,
			Date date) {
		super(id, createdBy, modifiedBy, createdDateTime, modifiedDateTime);
		this.userId = userId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.status = status;
		this.timing = timing;
		this.date = date;
	}
	




/**
 * @param userId
 * @param name
 * @param mobileNo
 * @param status
 * @param timing
 * @param date
 */
public GuardTrainingEntity(long userId, String name, String mobileNo, String status, String timing, Date date) {
	super();
	this.userId = userId;
	this.name = name;
	this.mobileNo = mobileNo;
	this.status = status;
	this.timing = timing;
	this.date = date;
}




public GuardTrainingEntity() {

}
	
	
}
