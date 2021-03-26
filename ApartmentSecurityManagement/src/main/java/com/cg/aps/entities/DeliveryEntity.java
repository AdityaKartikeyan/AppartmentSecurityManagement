/**
 * 
 */
package com.cg.aps.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vishal Rana
 *
 */
@Entity
@Table(name = "Delivery")
public class DeliveryEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long deliveryId;
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
	public DeliveryEntity(long id, String createdBy, String modifiedBy, LocalDateTime createdDateTime,
			LocalDateTime modifiedDateTime, int deliveryId, String ownerName, String time, Date date) {
		super(id, createdBy, modifiedBy, createdDateTime, modifiedDateTime);
		this.deliveryId = deliveryId;
		this.ownerName = ownerName;
		this.time = time;
		this.date = date;
	}

	public DeliveryEntity() {

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
