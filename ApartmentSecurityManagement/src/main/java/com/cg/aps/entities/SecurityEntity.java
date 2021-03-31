/**
 * 
 */
package com.cg.aps.entities;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Aditya
 *
 */
@Entity
@Table(name="Security")
public class SecurityEntity extends BaseEntity {


	private String alertId;
	private String alertMessage;
	private String alertType;
	
	
	 
	


	/**
	 * @return the alertId
	 */
	public String getAlertId() {
		return alertId;
	}






	/**
	 * @param alertId the alertId to set
	 */
	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}






	/**
	 * @return the alertMessage
	 */
	public String getAlertMessage() {
		return alertMessage;
	}






	/**
	 * @param alertMessage the alertMessage to set
	 */
	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}






	/**
	 * @return the alertType
	 */
	public String getAlertType() {
		return alertType;
	}






	/**
	 * @param alertType the alertType to set
	 */
	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}






	/**
	 * @param alertId
	 * @param alertMessage
	 * @param alertType
	 */
	public SecurityEntity(String alertId, String alertMessage, String alertType) {
		super();
		this.alertId = alertId;
		this.alertMessage = alertMessage;
		this.alertType = alertType;
	}






	/**
	 * @param id
	 * @param createdBy
	 * @param modifiedBy
	 * @param createdDateTime
	 * @param modifiedDateTime
	 * @param alertId
	 * @param alertMessage
	 * @param alertType
	 */
	public SecurityEntity(long id, String createdBy, String modifiedBy, LocalDateTime createdDateTime,
			LocalDateTime modifiedDateTime, String alertId, String alertMessage, String alertType) {
		super(id, createdBy, modifiedBy, createdDateTime, modifiedDateTime);
		this.alertId = alertId;
		this.alertMessage = alertMessage;
		this.alertType = alertType;
	}






	public SecurityEntity() {
	
	}
}
