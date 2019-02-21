package com.coffeeshop.CoffeeShopApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		return new ModelAndView("/index", "list", item);
	}
	
	@RequestMapping("/admin")
	public ModelAndView showAdminPage() {
		List<ShopItems> item = itemsDao.findAll();
		return new ModelAndView("/admin-page", "list", item);
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
	
	@PostMapping("/admin-add")
	public ModelAndView addItem(ShopItems item) {		
		itemsDao.create(item);
		
		return new ModelAndView("redirect:/admin");
	}
	
	@PostMapping("/admin-delete")
	public ModelAndView deleteItem(
			@RequestParam("id") int id) {
		System.out.println(id);
		itemsDao.delete(id);
		
		return new ModelAndView("redirect:/admin");
	}
}
