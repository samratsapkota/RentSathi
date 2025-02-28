package com.rent.sprite;

import java.sql.Timestamp;
import java.util.UUID;

import com.rent.model.Status;

public class AdminBookingTable {

	private UUID bookingId;

	private UUID rentId;

	private String name;

	private String email;

	private long mobileno;

	private String comment;

	private String rentType;

	private Timestamp createdAt;

	private String location;

	private String PropertySpecification;

	private String title;

	private long price;

	private String description;

	private Status status;

	public UUID getBookingId() {
		return bookingId;
	}

	public void setBookingId(UUID bookingId) {
		this.bookingId = bookingId;
	}

	public UUID getRentId() {
		return rentId;
	}

	public void setRentId(UUID rentId) {
		this.rentId = rentId;
	}

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPropertySpecification() {
		return PropertySpecification;
	}

	public void setPropertySpecification(String propertySpecification) {
		PropertySpecification = propertySpecification;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AdminBookingTable [bookingId=" + bookingId + ", rentId=" + rentId + ", name=" + name + ", email="
				+ email + ", mobileno=" + mobileno + ", comment=" + comment + ", rentType=" + rentType + ", createdAt="
				+ createdAt + ", location=" + location + ", PropertySpecification=" + PropertySpecification + ", title="
				+ title + ", price=" + price + ", description=" + description + ", status=" + status + "]";
	}
}
