package com.cg.aps.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author Vishal Rana
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "base")
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

	@Id
	@GeneratedValue
	protected long id;

	@CreatedBy
	@Column(name = "created_by")
	protected String createdBy;

	@LastModifiedBy
	@Column(name = "modified_by")
	protected String modifiedBy;

	@CreationTimestamp
	@Column(name = "created_date")
	protected LocalDateTime createdDateTime;

	@UpdateTimestamp
	@Column(name = "modified_date")
	protected LocalDateTime modifiedDateTime;

	public BaseEntity() {
	}

	/**
	 * @param id
	 * @param createdBy
	 * @param modifiedBy
	 * @param createdDateTime
	 * @param modifiedDateTime
	 */
	public BaseEntity(long id, String createdBy, String modifiedBy, LocalDateTime createdDateTime,
			LocalDateTime modifiedDateTime) {
		super();
		this.id = id;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdDateTime = createdDateTime;
		this.modifiedDateTime = modifiedDateTime;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the createdDateTime
	 */
	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	/**
	 * @param createdDateTime the createdDateTime to set
	 */
	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	/**
	 * @return the modifiedDateTime
	 */
	public LocalDateTime getModifiedDateTime() {
		return modifiedDateTime;
	}

	/**
	 * @param modifiedDateTime the modifiedDateTime to set
	 */
	public void setModifiedDateTime(LocalDateTime modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}
	
}
