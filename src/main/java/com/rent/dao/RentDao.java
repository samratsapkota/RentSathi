package com.rent.dao;

import java.util.List;
import java.util.UUID;

import com.rent.model.Rent;
import com.rent.model.Status;
import com.rent.sprite.DescriptionResult;
import com.rent.sprite.RentList;

public interface RentDao {

	Boolean addUpload(Rent rent);
	
	Rent getRentId(UUID rent_id);
	
	String getRentType(UUID rent_id);
	
	Boolean updateRent(Rent rent);
	
	Boolean changestatus(UUID rentId, Status status);
	
	List<RentList> getAllRent();
	
	Boolean deleteRent(UUID rent_id);
	
	List<String> getDescription();
	
	
}
