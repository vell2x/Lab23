package com.coffeeshop.CoffeeShopApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.coffeeshop.CoffeeShopApp.dao.UserDao;
import com.coffeeshop.CoffeeShopApp.dao.ItemsDao;

@Controller
public class CoffeeShopController {
	@Autowired
	UserDao userDao;
	
	@Autowired
	private ItemsDao itemsDao;
	
	@RequestMapping("/")
	public ModelAndView showHome() {
		List<ShopItems> item = itemsDao.findAll();
		System.out.println(item);
		return new ModelAndView("/index", "list", item);
	}
	
	@RequestMapping("/registration")
	public ModelAndView showRegistrationPage() {
		return new ModelAndView("registration");
	}
	
	@PostMapping("/registered")
	public ModelAndView addSubmit(UserProfile user) {		
		userDao.create(user);
		
		ModelAndView mav = new ModelAndView("/registration-successful");
		mav.addObject("firstName", user.getFirstName());
		mav.addObject("lastName", user.getLastName());
		
		return mav;
	}
}
