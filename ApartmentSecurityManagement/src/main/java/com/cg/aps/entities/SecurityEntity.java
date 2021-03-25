/**
 * 
 */
package com.cg.aps.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Administrator
 *
 */
@Entity
@Table(name="Security")
public class SecurityEntity extends BaseEntity {

	@Id
	private Integer alertId;
	private String alertMessage;
	private String alertType;
	private LocalDate alertDate;
	/**
	 * @return the alertId
	 */
	public Integer getAlertId() {
		return alertId;
	}
	/**
	 * @param alertId the alertId to set
	 */
	public void setAlertId(Integer alertId) {
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
	 * @return the alertDate
	 */
	public LocalDate getAlertDate() {
		return alertDate;
	}
	/**
	 * @param alertDate the alertDate to set
	 */
	public void setAlertDate(LocalDate alertDate) {
		this.alertDate = alertDate;
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
	 * @param alertDate
	 */
	public SecurityEntity(long id, String createdBy, String modifiedBy, LocalDateTime createdDateTime,
			LocalDateTime modifiedDateTime, Integer alertId, String alertMessage, String alertType, LocalDate alertDate) {
		super(id, createdBy, modifiedBy, createdDateTime, modifiedDateTime);
		this.alertId = alertId;
		this.alertMessage = alertMessage;
		this.alertType = alertType;
		this.alertDate = alertDate;
	}
	
	
}
