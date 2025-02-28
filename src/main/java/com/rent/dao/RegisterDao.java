package com.rent.dao;

import java.util.List;
import java.util.UUID;

import com.rent.model.Register;
import com.rent.sprite.RegisterTable;

public interface RegisterDao {

	Boolean setRegisterDetail(Register register);

	String getEmail(String email);

	String getPassword(String password);

	UUID getIdByEmail(String email);

	Register getRegisterId(UUID regId);

	List<RegisterTable> getRegisterDetail(UUID regId);

	Boolean deteleUserReg(UUID regId);
}
