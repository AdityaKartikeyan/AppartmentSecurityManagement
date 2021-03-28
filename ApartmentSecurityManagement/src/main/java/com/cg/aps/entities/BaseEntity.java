package com.cg.aps.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
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

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getCreatedBy() {
	return createdBy;
}

public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}

public String getModifiedBy() {
	return modifiedBy;
}

public void setModifiedBy(String modifiedBy) {
	this.modifiedBy = modifiedBy;
}

public LocalDateTime getCreatedDateTime() {
	return createdDateTime;
}

public void setCreatedDateTime(LocalDateTime createdDateTime) {
	this.createdDateTime = createdDateTime;
}

public LocalDateTime getModifiedDateTime() {
	return modifiedDateTime;
}

public void setModifiedDateTime(LocalDateTime modifiedDateTime) {
	this.modifiedDateTime = modifiedDateTime;
}

public BaseEntity(long id, String createdBy, String modifiedBy, LocalDateTime createdDateTime, LocalDateTime modifiedDateTime) {
	super();
	this.id = id;
	this.createdBy = createdBy;
	this.modifiedBy = modifiedBy;
	this.createdDateTime = createdDateTime;
	this.modifiedDateTime = modifiedDateTime;
}

public BaseEntity() {
	// TODO Auto-generated constructor stub
}
}
