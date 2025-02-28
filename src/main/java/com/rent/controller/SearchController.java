package com.rent.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rent.dao.SearchDao;

@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	SearchDao searchDao;

	@RequestMapping(path = "/housedetail", method = RequestMethod.GET)
	public String UploadGet(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("rentDetails", searchDao.getRentDetailByHouse());
		// System.out.println(uploadDao.getRentDetail());

		return "flatroomhouse";
	}

	@RequestMapping(path = "/flatdetail", method = RequestMethod.GET)
	public String UploadGetByFalt(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("rentDetails", searchDao.getRentDetailByFlat());
		// System.out.println(uploadDao.getRentDetail());

		return "flatroomhouse";
	}

	@RequestMapping(path = "/roomdetail", method = RequestMethod.GET)
	public String UploadGetByRoom(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("rentDetails", searchDao.getRentDetailByRoom());
		// System.out.println(uploadDao.getRentDetail());

		return "flatroomhouse";
	}

	
	
	
}
