package com.cg.aps.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author AMBARISH DATAR
 *
 */
@Entity
@Table(name="Visitor")
public class VisitorEntity extends BaseEntity{

	private String name;
	private String ownerName;
	private String flatNo;
	private Date date;
	private String arrivalTime;
	private String departureTime;
	
	public VisitorEntity(long id, String createdBy, String modifiedBy, LocalDateTime createdDateTime,
			LocalDateTime modifiedDateTime, String name, String ownerName, String flatNo, Date date, String arrivalTime,
			String departureTime) {
		super(id, createdBy, modifiedBy, createdDateTime, modifiedDateTime);
		this.name = name;
		this.ownerName = ownerName;
		this.flatNo = flatNo;
		this.date = date;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	
	public VisitorEntity() {
		// TODO Auto-generated constructor stub
	}
}
