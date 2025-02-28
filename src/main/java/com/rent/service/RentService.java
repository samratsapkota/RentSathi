package com.rent.service;

import com.rent.sprite.RentTable;

public interface RentService {
	
	Boolean setUpload(RentTable rentTable, Integer userId, String img_name, byte[] img_path);

}
