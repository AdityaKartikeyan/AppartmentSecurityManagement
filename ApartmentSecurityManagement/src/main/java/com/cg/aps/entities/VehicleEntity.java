package com.cg.aps.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vehicle")
public class VehicleEntity extends BaseEntity {

	private String name;
	private String parkingNo;
	private String arrivalTime;
	private String departureTime;
	private Date date;
	/**
	 * @author Anshul Joshi
	 */
	@Id
	private String vehicleNo;
	private String vehicleType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParkingNo() {
		return parkingNo;
	}

	public void setParkingNo(String parkingNo) {
		this.parkingNo = parkingNo;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public VehicleEntity() {
		// TODO Auto-generated constructor stub
	}
	public VehicleEntity(long id, String createdBy, String modifiedBy, LocalDateTime createdDateTime,
			LocalDateTime modifiedDateTime, String name, String parkingNo, String arrivalTime,
			String departureTime, Date date, String vehicleNo, String vehicleType) {
		super(id, createdBy, modifiedBy, createdDateTime, modifiedDateTime);
		this.name = name;
		this.parkingNo = parkingNo;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.date = date;
		this.vehicleNo = vehicleNo;
		this.vehicleType = vehicleType;
	}

	@Override
	public String toString() {
		return "VehicleEntity [name=" + name + ", parkingNo=" + parkingNo + ", arrivalTime=" + arrivalTime
				+ ", departureTime=" + departureTime + ", date=" + date + ", vehicleNo=" + vehicleNo + ", vehicleType="
				+ vehicleType + "]";
	}

}
