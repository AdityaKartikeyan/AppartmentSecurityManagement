package com.cg.aps.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table (name="DomesticHelp")
public class DomesticHelpEntity extends BaseEntity {
	@Id
	private String flatNo;
	private String ownerName;
	private String name;
	private String helpType;
	private String arrivalTime;
	private String departureTime;
	private String date;
	public String getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHelpType() {
		return helpType;
	}
	public void setHelpType(String helpType) {
		this.helpType = helpType;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public DomesticHelpEntity(long id, String createdBy, String modifiedBy, Timestamp createdDateTime,
			Timestamp modifiedDateTime, String flatNo, String ownerName, String name, String helpType,
			String arrivalTime, String departureTime, String date) {
		super(id, createdBy, modifiedBy, createdDateTime, modifiedDateTime);
		this.flatNo = flatNo;
		this.ownerName = ownerName;
		this.name = name;
		this.helpType = helpType;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.date = date;
	}
	
	public DomesticHelpEntity() {
		// TODO Auto-generated constructor stub
	}
	
	}
	
	
	

