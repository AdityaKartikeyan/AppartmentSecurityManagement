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
	private String ownerName;
	private String time;
	private Date date;


	/**
	 * @param id
	 * @param createdBy
	 * @param modifiedBy
	 * @param createdDateTime
	 * @param modifiedDateTime
	 * @param ownerName
	 * @param time
	 * @param date
	 * @param status
	 */
	public DeliveryEntity(long id, String createdBy, String modifiedBy, Timestamp createdDateTime,
			Timestamp modifiedDateTime, String ownerName, String time, Date date, String status) {
		super(id, createdBy, modifiedBy, createdDateTime, modifiedDateTime);
		this.ownerName = ownerName;
		this.time = time;
		this.date = date;
		this.status = status;
	}

	private String status;

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

	@Override
	public String toString() {
		return "DeliveryEntity [ownerName=" + ownerName + ", time=" + time + ", date=" + date + ", status=" + status
				+ "]";
	}
}
