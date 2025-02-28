package com.rent.service;

import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rent.controller.CommonController;
import com.rent.dao.BookingDao;
import com.rent.dao.RentDao;
import com.rent.dao.UserDao;
import com.rent.model.Booking;
import com.rent.model.Rent;
import com.rent.model.Status;
import com.rent.model.User;
import com.rent.sprite.BookingTable;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingDao bookingDao;
	
	@Autowired
	RentDao rentDao;
	
	@Autowired
	UserDao userDao;
	
	@Override
	public Boolean addBookingDetails(BookingTable bookingTable, UUID rent_id, String user_email) {
		Rent rent = rentDao.getRentId(rent_id);
		System.out.println("rent servicce "+ rent);
		String rent_type = rentDao.getRentType(rent_id);
		User user_id = userDao.getExistingUser(user_email);
		
		Booking book = new Booking();
		
		book.setName(bookingTable.getName());
		book.setEmail(bookingTable.getEmail());
		book.setMobileno(bookingTable.getMobileno());
		book.setComment(bookingTable.getComment());
		book.setRentType(rent_type);
		book.setCreatedAt(CommonController.getCurrentDateTime());
		book.setRent(rent);
		book.setUser(user_id);
		
		rent.setStatus(Status.pending);
		book.setStatus(rent.getStatus());
		 boolean success = bookingDao.setBookingDetails(book);
		    if (success) {
		        rentDao.updateRent(rent); // Update the status in the database
		    }
		
		
		return success;
	}

}
