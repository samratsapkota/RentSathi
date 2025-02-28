package com.rent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rent.controller.CommonController;
import com.rent.dao.RegisterDao;
import com.rent.dao.UserDao;
import com.rent.model.Register;
import com.rent.sprite.RegisterTable;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	RegisterDao registerDao;

	@Autowired
	UserDao userDao;

	@Override
	public Boolean addRegisterDetails(RegisterTable regTable) {
		Register register = new Register();
		//User user = new User();

		register.setDob(CommonController.convertStringToDate(regTable.getDob()));
		register.setEmail(regTable.getEmail());
		register.setFullname(regTable.getFullname());
		register.setGender(regTable.getGender());
		register.setMobileno(regTable.getMobileno());
		register.setOccupation(regTable.getOccupation());
		register.setAddressType(regTable.getAddressType());
		register.setDistrict(regTable.getDistrict());
		register.setCity(regTable.getCity());
		register.setPassword(regTable.getPassword());
		register.setProvince(regTable.getProvince());
		register.setIssuedAuthority(regTable.getIssuedAuthority());
		register.setIdType(regTable.getIdType());
		register.setIdNo(regTable.getIdNo());
		register.setCreatedAt(CommonController.getCurrentDateTime());
		//register.setUserId(user.getId());

		return registerDao.setRegisterDetail(register);
	}

	

}
