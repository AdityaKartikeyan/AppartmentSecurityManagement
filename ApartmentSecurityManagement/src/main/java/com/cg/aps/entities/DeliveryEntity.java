/**
 * 
 */
package com.cg.aps.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Vishal Rana
 *
 */
@Entity
@Table(name = "Delivery")
public class DeliveryEntity extends BaseEntity {

	private String ownerName;
	private String time;
	private Date date;
	private String status;

	/**
	 * @param ownerName
	 * @param time
	 * @param date
	 * @param status
	 */
	public DeliveryEntity(String ownerName, String time, Date date, String status) {
		super();
		this.ownerName = ownerName;
		this.time = time;
		this.date = date;
		this.status = status;
	}

	/**
	 * @return the ownerName
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * @param ownerName the ownerName to set
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
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

	public DeliveryEntity() {
	}
}
