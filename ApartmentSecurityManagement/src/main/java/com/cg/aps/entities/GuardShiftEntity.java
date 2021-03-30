package com.cg.aps.entities;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author HP
 *
 */
@Entity
@Table(name="GuardShift")


public class GuardShiftEntity extends BaseEntity
{
	
	
	
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	public GuardShiftEntity(long userId, String name, String time, Date date) {
		super();
		this.userId = userId;
		this.name = name;
		this.time = time;
		this.date = date;
	}
public GuardShiftEntity(long id, String createdBy, String modifiedBy, LocalDateTime createdDateTime,
			LocalDateTime modifiedDateTime, long userId, String name, String time, Date date) {
		super(id, createdBy, modifiedBy, createdDateTime, modifiedDateTime);
		this.userId = userId;
		this.name = name;
		this.time = time;
		this.date = date;
	}
public GuardShiftEntity() {
	// TODO Auto-generated constructor stub
}
}
