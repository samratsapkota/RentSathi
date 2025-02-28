package com.rent.sprite;

import java.sql.Date;
import java.util.UUID;

import com.rent.model.Status;

public class RentList {

	String rentType;

	String location;

	String propertySpecification;

	String title;

	long price;

	String description;
	
	Date created_at;

	String imgpath;
	
	String imgname;
	
	UUID rent_id;
	
	Status status;
	
	String createdBy;

	public String getRentType() {
		return rentType;
	}

	public void setRentType(String rentType) {
		this.rentType = rentType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPropertySpecification() {
		return propertySpecification;
	}

	public void setPropertySpecification(String propertySpecification) {
		this.propertySpecification = propertySpecification;
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

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	public UUID getRent_id() {
		return rent_id;
	}

	public void setRent_id(UUID rent_id) {
		this.rent_id = rent_id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "RentList [rentType=" + rentType + ", location=" + location + ", propertySpecification="
				+ propertySpecification + ", title=" + title + ", price=" + price + ", description=" + description
				+ ", created_at=" + created_at + ", imgpath=" + imgpath + ", imgname=" + imgname + ", rent_id="
				+ rent_id + ", status=" + status + ", createdBy=" + createdBy + "]";
	}

	public RentList(String rentType, String location, String propertySpecification, String title, long price,
			String description, Date created_at, String imgpath, String imgname, UUID rent_id, Status status,
			String createdBy) {
		super();
		this.rentType = rentType;
		this.location = location;
		this.propertySpecification = propertySpecification;
		this.title = title;
		this.price = price;
		this.description = description;
		this.created_at = created_at;
		this.imgpath = imgpath;
		this.imgname = imgname;
		this.rent_id = rent_id;
		this.status = status;
		this.createdBy = createdBy;
	}

	public RentList() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
