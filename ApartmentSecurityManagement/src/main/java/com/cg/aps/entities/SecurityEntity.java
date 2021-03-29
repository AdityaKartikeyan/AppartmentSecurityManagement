/**
 * 
 */
package com.cg.aps.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Administrator
 *
 */
@Entity
@Table(name="Security")
public class SecurityEntity extends BaseEntity {


	
	private String alertMessage;
	private String alertType;
	
	
	 
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
	 * @param alertMessage
	 * @param alertType
	 */
	public SecurityEntity(String alertMessage, String alertType) {
		super();
		this.alertMessage = alertMessage;
		this.alertType = alertType;
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



	public SecurityEntity() {
		// TODO Auto-generated constructor stub
	}
}
