package com.rent.service;

import java.util.UUID;

import com.rent.sprite.BookingTable;

public interface BookingService {
	
	Boolean addBookingDetails(BookingTable bookingTable, UUID rent_id, String user_email);
	
	

}
