package com.cg.aps.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="FlatRent")

public class FlatRentEntity extends BaseEntity {

	private String ownerName;
	private String flatNo;
	private String amount;
	private String type;
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
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	


}
