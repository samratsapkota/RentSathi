package com.rent;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rent.dao.SearchDao;
import com.rent.dao.UserDao;
import com.rent.sprite.RentList;

@Controller
public class HomeController {

	@Autowired
	SearchDao searchDao;

	@Autowired
	UserDao userDao;

	@RequestMapping(value = "/intro")
	public String home(Model model, HttpServletRequest request) {

		if (request.getSession().getAttribute("login") != null) {
			List<RentList> rentDetails = searchDao.getRentDetail();

			String email = (String) request.getSession().getAttribute("login");
			Integer user_id = userDao.getExistingUserId(email);
			// System.out.println("user_id:" + user_id);
			String userLocation = userDao.District(user_id);
			// System.out.println("location:" + userLocation);
			quickSort(rentDetails, 0, rentDetails.size() - 1, userLocation);


			model.addAttribute("msg", "msgggg");
			model.addAttribute("rentDetails", rentDetails);
			return "intro";
		} else {
			model.addAttribute("rentDetails", searchDao.getRentDetail());
			return "intro";
		}

	}

	@RequestMapping(value = "/login")
	public String Login() {
		return "login";
	}

	/*
	 * @RequestMapping(value = "/intrologin") public String homelogin(Model model,
	 * HttpServletRequest request) {
	 * 
	 * List<RentList> rentDetails = searchDao.getRentDetail();
	 * 
	 * String email = (String) request.getSession().getAttribute("login"); Integer
	 * user_id = userDao.getExistingUserId(email); // System.out.println("user_id:"
	 * + user_id); String userLocation = userDao.District(user_id); //
	 * System.out.println("location:" + userLocation); List<RentList> rentDetail =
	 * quickSort(rentDetails, userLocation);
	 * 
	 * model.addAttribute("rentDetails", rentDetail); return "intro"; }
	 */

	// quick sorting algorithm for sorting the details based on the loaction of
	// logged in user's location
	private static List<RentList> quickSort(List<RentList> arr, int low, int high, String userLocation) {
	    if (low < high) {
	        int pi = partition(arr, low, high, userLocation);
	        quickSort(arr, low, pi - 1, userLocation); // Corrected to pi - 1
	        quickSort(arr, pi + 1, high, userLocation); // Corrected to pi + 1
	    }
	    return arr;
	}

	private static int partition(List<RentList> arr, int low, int high, String userLocation) {
	    int i = low - 1;
	    for (int j = low; j < high; j++) {
	        String location = arr.get(j).getLocation();
	        if (location != null && location.equals(userLocation)) {
	            i++;
	            swap(arr, i, j);
	        }
	    }
	    // Move the pivot to its correct position
	    swap(arr, i + 1, high);
	    return i + 1;
	}



	private static void swap(List<RentList> arr, int i, int j) {
	    RentList temp = arr.get(i);
	    arr.set(i, arr.get(j));
	    arr.set(j, temp);
	}

}
