package com.coffeeshop.CoffeeShopApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeShopController {
	@Autowired
	CustomerList user;
	
	@RequestMapping("/")
	public ModelAndView showHome() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/registration")
	public ModelAndView showRegistrationPage() {
		return new ModelAndView("registration");
	}
	
	@RequestMapping("/registered")
	public ModelAndView registrationComplete(
			@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname,
			@RequestParam("email") String email,
			@RequestParam("phonenumber") int phonenumber,
			@RequestParam("password") String password) {
		user.addCustomer(firstname, lastname, email, phonenumber, password);
		String fName = firstname;
		String lName = lastname;
		
		ModelAndView mav = new ModelAndView("/registration-successful");
		mav.addObject("firstname", fName);
		mav.addObject("lastname", lName);
		return mav;
	}
}
