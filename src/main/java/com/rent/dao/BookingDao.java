package com.rent.dao;

import java.util.List;

import com.rent.model.Booking;
import com.rent.model.Status;
import com.rent.sprite.AdminBookingTable;
import com.rent.sprite.BookingTable;
import com.rent.sprite.RentList;

public interface BookingDao {
	
	Boolean setBookingDetails(Booking booking);
	
	public List<RentList> getRentDetailsByBooking(Integer user_id);
	
	List<AdminBookingTable> getAllBookingsBooked();
	
	Status getStatus(Integer user_id);


}
