package com.cg.aps.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Flat")
public class FlatEntity extends BaseEntity {

	private String ownerName;
	private String flatNo;
	private String floorNo;
	private String flatType;
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
	public String getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}
	public String getFlatType() {
		return flatType;
	}
	public void setFlatType(String flatType) {
		this.flatType = flatType;
	}
	public FlatEntity(long id, String createdBy, String modifiedBy, Timestamp createdDateTime,
			Timestamp modifiedDateTime, String ownerName, String flatNo, String floorNo, String flatType) {
		super(id, createdBy, modifiedBy, createdDateTime, modifiedDateTime);
		this.ownerName = ownerName;
		this.flatNo = flatNo;
		this.floorNo = floorNo;
		this.flatType = flatType;
	}

	
	
}
