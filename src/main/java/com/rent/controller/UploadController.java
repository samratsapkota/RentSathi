package com.rent.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mysql.cj.Session;
import com.rent.dao.RegisterDao;
import com.rent.dao.RentDao;
import com.rent.dao.UserDao;
import com.rent.service.RentService;
import com.rent.sprite.RentTable;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@Autowired
	RentService rentService;
	
	@Autowired
	RegisterDao registerDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	RentDao rentDao;
	
	@RequestMapping(path="/add", method = RequestMethod.POST)
	public String Upload(@RequestParam("img") CommonsMultipartFile image, HttpServletRequest request, @ModelAttribute("upload") RentTable rentTable)
	{
		//upload only by admin@gmail.com
		String email =(String) request.getSession().getAttribute("login");
		if(email.equalsIgnoreCase("admin@gmail.com"))
		{
			//System.out.println(image.getOriginalFilename());
			
			byte[] img_byte = image.getBytes();
			//System.out.println(img_byte);
			
			
			//System.out.println(rentTable.getPropertySpecification());
			
			String userEmail = (String) request.getSession().getAttribute("login");
			System.out.println("userEmail: "+userEmail);
			
			if( userDao.getExistingUser(userEmail).getId()!=null)
			{
				Integer userId = userDao.getExistingUser(userEmail).getId();
				//System.out.println("user id:"+userId);
				
				//System.out.println("---------------------------------");
				rentService.setUpload(rentTable, userId, image.getOriginalFilename(), img_byte);
			}
			
			
			
			//gives path of the image folder after the project has been run, not the one on the project.
			//String path = request.getServletContext().getRealPath("/resources/Images/"+image.getOriginalFilename());
			//System.out.println(path);
//			FileOutputStream fos;
//			try {
//				fos = new FileOutputStream(path);
//				fos.write(img_byte);
//				fos.close();
//				System.out.println("Image uploaded");
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			
			return "redirect:/intro";
		}
		return "redirect:/intro";
		
	}
	
	/*@RequestMapping(path="/housedetail", method = RequestMethod.GET)
	public String UploadGet(HttpServletRequest request, HttpServletResponse response, Model model)
	{
		model.addAttribute("rentDetails", uploadDao.getRentDetailByHouse());
		//System.out.println(uploadDao.getRentDetail());
			
		return "demo";
	}*/
	
	
	
}
