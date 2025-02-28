package com.rent.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rent.dao.SearchDao;
import com.rent.sprite.DescriptionResult;
import com.rent.sprite.RentList;
import com.rent.util.RecommendationModel;

@Controller
@RequestMapping("/model")
public class ModelController {

	@Autowired
	RecommendationModel recommendationModel;
	
	@Autowired
	SearchDao searchDao;

	
	
	/*@RequestMapping(path = "/search", method = RequestMethod.GET)
	public String SearchByDistrict(HttpServletRequest request, HttpServletResponse response, Model model) {
		String district = request.getParameter("district");
		//System.out.println("Search by district: " + district);
		
		String rentType = request.getParameter("rentType");
		//System.out.println("Search by rentType: " + rentType);

		//System.out.println(searchDao.getRentDetailByDistrict(district, rentType));
		
		if(!searchDao.getRentDetailByDistrict(district, rentType).isEmpty())
		{
			model.addAttribute("rentDetails", searchDao.getRentDetailByDistrict(district, rentType));
		}else
		{
			model.addAttribute("error", "No Data available");
		}
		
		String user_pref = request.getParameter("description");
		List<DescriptionResult> output = recommendationModel.getTop5SimilarDescriptions(user_pref);

		// Filter out DescriptionResult objects with similarity score greater than 0
		List<DescriptionResult> filteredOutput = output.stream()
		        .filter(descriptionResult -> descriptionResult.getSimilarityScore() > 0)
		        .collect(Collectors.toList());

		System.out.println("output : " + filteredOutput);
		model.addAttribute("rentDetails", searchDao.getRentDetailByUserPref(filteredOutput));
		
		

		
		return "intro";
	}*/
	/*@RequestMapping(path = "/search", method = RequestMethod.GET)
	public String SearchByDistrict(HttpServletRequest request, HttpServletResponse response, Model model) {
		String district = request.getParameter("district");
		//System.out.println("Search by district: " + district);
		
		String rentType = request.getParameter("rentType");
		//System.out.println("Search by rentType: " + rentType);

		//System.out.println(searchDao.getRentDetailByDistrict(district, rentType));
		
		String user_pref = request.getParameter("description");
		
		if(!searchDao.getRentDetailByDistrict(district, rentType).isEmpty() && !recommendationModel.getTop5SimilarDescriptions(user_pref).isEmpty())
		{
			//rentype and district
			List<RentList> rentDetailsByDistrict = searchDao.getRentDetailByDistrict(district, rentType);
			
			//description
			List<DescriptionResult> output = recommendationModel.getTop5SimilarDescriptions(user_pref);

			// Filter out DescriptionResult objects with similarity score greater than 0
			List<DescriptionResult> filteredOutput = output.stream()
			        .filter(descriptionResult -> descriptionResult.getSimilarityScore() > 0)
			        .collect(Collectors.toList());

			System.out.println("output : " + filteredOutput);
			
			List<RentList> rentDetailsByUserPref = searchDao.getRentDetailByUserPref(filteredOutput);
			
			// Combine the two lists of rental details
			List<RentList> combinedRentDetails = new ArrayList<>();
			combinedRentDetails.addAll(rentDetailsByDistrict);
			combinedRentDetails.addAll(rentDetailsByUserPref);

			// Add the combined list to the model
			model.addAttribute("rentDetails", combinedRentDetails);
		}else
		{
			model.addAttribute("error", "No Data available");
		}
		
				
		return "intro";
	}*/
	
	@RequestMapping(path = "/search", method = RequestMethod.GET)
	public String SearchByDistrict(HttpServletRequest request, HttpServletResponse response, Model model) {
		String district = request.getParameter("district");
		//System.out.println("Search by district: " + district);
		
		String rentType = request.getParameter("rentType");
		//System.out.println("Search by rentType: " + rentType);

		//System.out.println(searchDao.getRentDetailByDistrict(district, rentType));
		
		String user_pref = request.getParameter("description");
		
		if(!searchDao.getRentDetailByDistrict(district, rentType).isEmpty() && !recommendationModel.getTop5SimilarDescriptions(user_pref).isEmpty())
		{
			List<DescriptionResult> output = recommendationModel.getTop5SimilarDescriptions(user_pref);

			// Filter out DescriptionResult objects with similarity score greater than 0
			List<DescriptionResult> filteredOutput = output.stream()
			        .filter(descriptionResult -> descriptionResult.getSimilarityScore() > 0)
			        .collect(Collectors.toList());

			System.out.println("output : " + filteredOutput);
			model.addAttribute("rentDetails", searchDao.getRentDetailByUserPrefDisRT(filteredOutput, district, rentType));
		}else
		{
			model.addAttribute("error", "No Data available");
		}
		
		
		
		
		

		
		return "intro";
	}
}
