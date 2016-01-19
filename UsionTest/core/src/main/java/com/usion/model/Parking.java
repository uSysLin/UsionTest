package com.usion.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "parking")
public class Parking extends BaseObject implements Serializable {
	private static final long serialVersionUID = 3832626162173359411L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@DocumentId
	private Long id;
	@Column(name = "parking_name", nullable = false, length = 50)
	@Field
	private String parkingName; // required
	@Column(name = "parking_status", nullable = false, length = 50)
	@Field
	private String parkingStatus; // required

	public String getParkingStatus() {
		return parkingStatus;
	}

	public void setParkingStatus(String parkingStatus) {
		this.parkingStatus = parkingStatus;
	}

	public Long getId() {
		return id;
	}

	public String getParkingName() {
		return parkingName;
	}

	public void setParkingName(String parkingName) {
		this.parkingName = parkingName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

}
