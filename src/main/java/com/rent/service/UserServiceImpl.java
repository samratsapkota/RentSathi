package com.rent.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rent.dao.RegisterDao;
import com.rent.dao.UserDao;
import com.rent.model.Register;
import com.rent.model.User;
import com.rent.sprite.UserTable;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	RegisterDao registerDao;
	
	@Override
	public Boolean setUser(UserTable userTable, UUID regId) {
		Register register = registerDao.getRegisterId(regId) ;
		User user = new User();
//		System.out.println("---------------------------------");
//		System.out.println("email"+userTable.getEmail());
//		System.out.println("pw"+userTable.getPassword());
//		System.out.println("id"+register);
//		System.out.println("---------------------------------");
		user.setEmail(userTable.getEmail());
		user.setPassword(userTable.getPassword());
		user.setRegId(register);
		
		return userDao.addUser(user);
	}

}
