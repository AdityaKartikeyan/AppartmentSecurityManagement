/**
 * 
 */
package com.cg.aps.entities;

import java.sql.Timestamp;
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

	private int deliveryId;
	private String ownerName;
	private String time;
	private Date date;
	/**
	 * @param id
	 * @param createdBy
	 * @param modifiedBy
	 * @param createdDateTime
	 * @param modifiedDateTime
	 * @param deliveryId
	 * @param ownerName
	 * @param time
	 * @param date
	 */
	public DeliveryEntity(long id, String createdBy, String modifiedBy, Timestamp createdDateTime,
			Timestamp modifiedDateTime, int deliveryId, String ownerName, String time, Date date) {
		super(id, createdBy, modifiedBy, createdDateTime, modifiedDateTime);
		this.deliveryId = deliveryId;
		this.ownerName = ownerName;
		this.time = time;
		this.date = date;
	}
	/**
	 * @return the deliveryId
	 */
	public int getDeliveryId() {
		return deliveryId;
	}
	/**
	 * @param deliveryId the deliveryId to set
	 */
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
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


}
