package com.rent.service;

import java.util.UUID;

import com.rent.sprite.UserTable;

public interface UserService {
	
	Boolean setUser(UserTable userTable, UUID regId);

	
}
