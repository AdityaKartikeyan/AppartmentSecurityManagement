/**
 * 
 */
package com.cg.aps.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Vishal Rana
 *
 */
@Entity
@Table(name = "delivery")
public class DeliveryEntity extends BaseEntity {

	private long deliveryId;
	private String ownerName;
	private String time;
	private Date date;
	private String status;

	public DeliveryEntity() {
	}

	/**
	 * @param deliveryId
	 * @param ownerName
	 * @param time
	 * @param date
	 * @param status
	 */
	public DeliveryEntity(long deliveryId, String ownerName, String time, Date date, String status) {
		super();
		this.deliveryId = deliveryId;
		this.ownerName = ownerName;
		this.time = time;
		this.date = date;
		this.status = status;
	}

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
	 * @param status
	 */
	public DeliveryEntity(long id, String createdBy, String modifiedBy, LocalDateTime createdDateTime,
			LocalDateTime modifiedDateTime, long deliveryId, String ownerName, String time, Date date, String status) {
		super(id, createdBy, modifiedBy, createdDateTime, modifiedDateTime);
		this.deliveryId = deliveryId;
		this.ownerName = ownerName;
		this.time = time;
		this.date = date;
		this.status = status;
	}

	/**
	 * @return the deliveryId
	 */
	public long getDeliveryId() {
		return deliveryId;
	}

	/**
	 * @param deliveryId the deliveryId to set
	 */
	public void setDeliveryId(long deliveryId) {
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

}
