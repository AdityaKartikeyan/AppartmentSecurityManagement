package com.cg.aps.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="GuardShift")


public class GuardShiftEntity extends BaseEntity
{
	
	public GuardShiftEntity(long id, String createdBy, String modifiedBy, Timestamp createdDateTime,
			Timestamp modifiedDateTime, long userId, String name, String time, Date date) {
		super(id, createdBy, modifiedBy, createdDateTime, modifiedDateTime);
		this.userId = userId;
		this.name = name;
		this.time = time;
		this.date = date;
	}
	private long userId;
	private String name;
	private String time;
	private Date date;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
