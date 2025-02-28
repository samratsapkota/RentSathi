package com.rent.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.python.antlr.PythonParser.else_clause_return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rent.dao.BookingDao;
import com.rent.dao.RegisterDao;
import com.rent.dao.UserDao;
import com.rent.model.User;
import com.rent.service.RegisterService;
import com.rent.service.UserService;
import com.rent.sprite.RegisterTable;
import com.rent.sprite.UserTable;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

	@Autowired
	RegisterService registerService;

	@Autowired
	UserService userService;

	@Autowired
	UserDao userDao;

	@Autowired
	RegisterDao registerDao;

	@Autowired
	BookingDao bookingDao;

	@RequestMapping(value = "/login")
	public String Login() {
		return "login";
	}

	@RequestMapping(path = "/loginPost", method = RequestMethod.POST)
	public String LoginPost(HttpServletRequest request, HttpServletResponse response, @ModelAttribute UserTable user,
			Model model) throws IOException {
		model.addAttribute("user", user);
		String em = request.getParameter("email");
		String pw = request.getParameter("password");
//		System.out.println("em: " + em);
//		System.out.println("pw: " + pw);

		String email = registerDao.getEmail(em);
		String password = registerDao.getPassword(pw);

//		System.out.println("email:" + email);
//		System.out.println("pw:" + password);

		UUID regId = registerDao.getIdByEmail(em);
		// System.out.println("id:" + regId);

		if (password != null && email.equalsIgnoreCase("admin@gmail.com") && password.equalsIgnoreCase("Admin12345678@")) {
			
			//this is original code but i doesnot add the admin details into the user table
			//request.getSession().setAttribute("login", user.getEmail());
			//System.out.println("user:"+user.getEmail());
			//return "redirect:/intro";
			
			
			request.getSession().setAttribute("login", user.getEmail());
			// request.getSession().setAttribute("userpw", user.getPassword());
			User us = userDao.getExistingUser(user.getEmail());
			// here if there is already an user then it redirects to intro exle it add the
			// registered user in to user table.
			if (us != null) {
				return "redirect:/intro";
			} else {
				userService.setUser(user, regId);
			}
			return "redirect:/intro";
			
		} else if (email != null && password != null) {
			
			request.getSession().setAttribute("login", user.getEmail());
			// request.getSession().setAttribute("userpw", user.getPassword());
			User us = userDao.getExistingUser(user.getEmail());
			// here if there is already an user then it redirects to intro exle it add the
			// registered user in to user table.
			if (us != null) {
				return "redirect:/intro";
			} else {
				userService.setUser(user, regId);
			}
			return "redirect:/intro";
			
		}else {
			
			model.addAttribute("error", "Email/Password didn't matched");
			return "login";
		}
		

		// LOgin for admin (static data)
//		  if (user.getEmail().equalsIgnoreCase("admin@gmail.com") &&
//		  user.getPassword().equalsIgnoreCase("admin")) {
//		  request.getSession().setAttribute("login", user.getEmail());
//		  request.getSession().setAttribute("userpw", user.getPassword()); User us =
//		  userDao.getExistingUser(user.getEmail()); if (us != null) { return "intro"; }
//		  else { userService.setUser(user); } return "intro"; } else {
//		  model.addAttribute("error", "Email/Password didn't matched"); return "login";
//		  }

	}

	@RequestMapping(value = "/register")
	public String Register() {
		return "register";
	}

	@RequestMapping(path = "/registerPost", method = RequestMethod.POST)
	public String RegisterPost(@Valid HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("registerTable") RegisterTable regTable, BindingResult result, Model model)
			throws IOException {
		if (result.hasErrors()) {
			model.addAttribute("errors", result);
			return "register";
		}

		String pw = request.getParameter("password");
		String confirm_pw = request.getParameter("confirmpassword");

		if (pw.equals(confirm_pw)) {
			registerService.addRegisterDetails(regTable);
		} else {
			model.addAttribute("error", "passwords didn't matched");
			return "register";
		}

		return "redirect:/intro";

	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/intro";
	}

	@RequestMapping(value = "/profile")
	public String profile(HttpServletRequest request, Model model) {

		// this does nothing for now
		User user = new User();
		String email = user.getEmail();
		model.addAttribute("useremail", email);
		model.addAttribute("userpw", user.getPassword());

		String user_email = (String) request.getSession().getAttribute("login");
//		System.out.println(email);
		Integer user_id = null;
		if (user_email != null) {
			user_id = userDao.getExistingUserId(user_email);
		} else {
			return "redirect:/intro";
		}

		// getting user's register details from logged in user(user_id)
		UUID regId = userDao.getRegisterId(user_id);
		// System.out.println("regId" + regId);
		model.addAttribute("registerDetail", registerDao.getRegisterDetail(regId));

		return "userprofile";
		// return "profile";
	}
	
	@RequestMapping(value = "/aboutus")
	public String aboutUs(HttpServletRequest request) {
		
		return "about-us";
	}
	
}
