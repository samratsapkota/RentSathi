package com.rent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rent.controller.CommonController;
import com.rent.dao.RentDao;
import com.rent.dao.UserDao;
import com.rent.model.Rent;
import com.rent.model.Status;
import com.rent.sprite.RentTable;

@Service
public class RentServiceImpl implements RentService {

	@Autowired
	RentDao rentDao;

	@Autowired
	UserDao userDao;

	@Override
	public Boolean setUpload(RentTable rentTable, Integer userId, String img_name, byte[] img_path) {
		Rent rent = new Rent();

		rent.setPropertySpecification(rentTable.getPropertySpecification());
		rent.setDescription(rentTable.getDescription());
		rent.setPrice(rentTable.getPrice());
		rent.setRentType(rentTable.getRentType());
		rent.setTitle(rentTable.getTitle());
		rent.setCreatedAt(CommonController.getCurrentDate());
		rent.setUpdatedAt(CommonController.getCurrentDate());
		rent.setDeletedAt(null);
		rent.setCreatedBy(userDao.getUser(userId));
		rent.setUpdatedBy(userDao.getUser(userId));
		rent.setImageName(img_name);
		rent.setImagePath(img_path);
		rent.setLocation(rentTable.getLocation());
		rent.setStatus(Status.available);

		return rentDao.addUpload(rent);

	}

}
