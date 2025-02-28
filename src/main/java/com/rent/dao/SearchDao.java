package com.rent.dao;

import java.util.List;

import com.rent.sprite.DescriptionResult;
import com.rent.sprite.RentList;

public interface SearchDao {

	List<RentList> getRentDetail();

	Boolean test();

	List<RentList> getRentDetailByHouse();

	List<RentList> getRentDetailByFlat();

	List<RentList> getRentDetailByRoom();

	List<RentList> getRentDetailByDistrict(String district, String rentType);
	
	//List<RentList> getRentDetailDis(String district);
	
	List<RentList> getRentDetailByUserPref(List<DescriptionResult> userPref);
	
	List<RentList> getRentDetailByUserPrefDisRT(List<DescriptionResult> userPref, String district, String rentType);

}
