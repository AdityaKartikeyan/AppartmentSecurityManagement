package com.cg.aps.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author AMBARISH DATAR
 *
 */
@Entity
@Table(name="Visitor")
public class VisitorEntity extends BaseEntity{

	private String visitorId;		//Visitor ID
	private String name;			//Visitor Name
	private String ownerName;		//Owner Name
	private String flatNo;			//Flat Number
	private Date date;				//Entry Date
	private String arrivalTime;		//Entry Time
	private String departureTime;	//Exit Time
	
	
	public VisitorEntity(String visitorId, String name, String ownerName, String flatNo, Date date, String arrivalTime,
			String departureTime) {
		super();
		this.visitorId = visitorId;
		this.name = name;
		this.ownerName = ownerName;
		this.flatNo = flatNo;
		this.date = date;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}


	public VisitorEntity(long id, String createdBy, String modifiedBy, LocalDateTime createdDateTime,
			LocalDateTime modifiedDateTime, String visitorId, String name, String ownerName, String flatNo, Date date,
			String arrivalTime, String departureTime) {
		super(id, createdBy, modifiedBy, createdDateTime, modifiedDateTime);
		this.visitorId = visitorId;
		this.name = name;
		this.ownerName = ownerName;
		this.flatNo = flatNo;
		this.date = date;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}


	public String getVisitorId() {
		return visitorId;
	}


	public void setVisitorId(String visitorId) {
		this.visitorId = visitorId;
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
