package com.rent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rent.dao.SearchDao;

@Controller
@RequestMapping("/rent")
public class RentController {
	
	@Autowired
	SearchDao searchDao;
	
	@RequestMapping(value="/upload")
	public String upload()
	{
		return "upload";
	}
	

}
