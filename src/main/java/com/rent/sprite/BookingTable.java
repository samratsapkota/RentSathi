package com.rent.sprite;

import java.sql.Timestamp;
import java.util.Date;

import com.rent.model.Status;

public class BookingTable {
	
	private String name;

	private String email;

	private long mobileno;

	private String comment;
	
	private String rentType;

	private Timestamp createdAt;
	
	private Status status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getRentType() {
		return rentType;
	}

	public void setRentType(String rentType) {
		this.rentType = rentType;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BookingTable [name=" + name + ", email=" + email + ", mobileno=" + mobileno + ", comment=" + comment
				+ ", rentType=" + rentType + ", createdAt=" + createdAt + ", status=" + status + "]";
	}

	
}
