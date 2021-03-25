package com.cg.aps.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * @author Aravind
 *
 */
@Entity
@Table(name="GuardSalary")


public class GuardSalaryEntity extends BaseEntity {

	private String name;
	@Id
	private long userId;
	private String amount;
	private String status;
	private Date date;
	
	public GuardSalaryEntity(long id, String createdBy, String modifiedBy, LocalDateTime createdDateTime,
			LocalDateTime modifiedDateTime, String name, long userId, String amount, String status, Date date) {
		super(id, createdBy, modifiedBy, createdDateTime, modifiedDateTime);
		this.name = name;
		this.userId = userId;
		this.amount = amount;
		this.status = status;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public GuardSalaryEntity() {
		// TODO Auto-generated constructor stub
	}
		
}