package com.coffeeshop.CoffeeShopApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.coffeeshop.CoffeeShopApp.dao.CustomerList;
import com.coffeeshop.CoffeeShopApp.dao.ShopList;

@Controller
public class CoffeeShopController {
	@Autowired
	CustomerList users;
	
	@Autowired
	private ShopList items;
	
	@RequestMapping("/")
	public ModelAndView showHome() {
		List<ShopItems> item = items.findAll();
		return new ModelAndView("list", "/", item);
	}
	
	@RequestMapping("/registration")
	public ModelAndView showRegistrationPage() {
		return new ModelAndView("registration");
	}
	
	@PostMapping("/registered")
	public ModelAndView addSubmit(UserProfile user) {		
		users.create(user);
		
		return new ModelAndView("/registration-successful");
	}
}
