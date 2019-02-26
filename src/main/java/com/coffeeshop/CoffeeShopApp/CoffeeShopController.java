package com.coffeeshop.CoffeeShopApp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.coffeeshop.CoffeeShopApp.dao.UserDao;

import com.coffeeshop.CoffeeShopApp.dao.CartDao;
import com.coffeeshop.CoffeeShopApp.dao.ItemsDao;

@Controller
public class CoffeeShopController {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ItemsDao itemsDao;
	
	@Autowired
	private CartDao cartDao;
	
	@RequestMapping("/")
	public ModelAndView showHome() {
		List<ShopItems> item = itemsDao.findAll();
		return new ModelAndView("/index", "list", item);
	}
	
	@RequestMapping("/admin")
	public ModelAndView showAdminPage(HttpServletResponse response) {
		List<ShopItems> item = itemsDao.findAll();
		return new ModelAndView("/admin-page", "list", item);
	}
	
	@RequestMapping("/registration")
	public ModelAndView showRegistrationPage(
			@SessionAttribute(name="profile", required=false) UserProfile user) {
		return new ModelAndView("registration");
	}
	
	@RequestMapping("/admin-edit")
	public ModelAndView showEditPage(
			@RequestParam("id") int id) {
		ShopItems item = itemsDao.findById(id);
		return new ModelAndView("/edit-page", "object", item);
	}
	
	@RequestMapping("/add-to-cart")
	public ModelAndView showCartPage(
			@RequestParam("id") int id) {
		ShopItems item = itemsDao.findById(id);
		return new ModelAndView("cart-page", "object", item);
	}
	
	@RequestMapping("/login")
	public ModelAndView showLoginForm() {
		return new ModelAndView("login");
	}

	@PostMapping("/login")
	public ModelAndView submitLoginForm(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpSession session) {
		UserProfile user = userDao.findByUsername(username);
		if (user == null || !password.equals(user.getPassword())) {
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("message", "Incorrect username or password.");
			return mav;
		}
		session.setAttribute("profile", user);
		List<ShopItems> item = itemsDao.findAll();
		return new ModelAndView("/index", "list", item);
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		List<ShopItems> item = itemsDao.findAll();
		return new ModelAndView("/index", "list", item);
	}
	
	@PostMapping("/registered")
	public ModelAndView addSubmit(UserProfile user, 
			@RequestParam("confirm-password") String confirmPassword,
			HttpSession session) {
		UserProfile existingUser = userDao.findByUsername(user.getUsername());
		if (existingUser != null) {
			return new ModelAndView("registration", "message", "This user already exist.");
		}
		
		if (!confirmPassword.equals(user.getPassword())) {
			return new ModelAndView("registration", "message", "Passwords do not match.");
		}
		userDao.create(user);
		session.setAttribute("profile", user);
		ModelAndView mav = new ModelAndView("/registration-successful");
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
	
	@PostMapping("/admin-edit")
	public ModelAndView editItem(ShopItems edit) {	
		itemsDao.update(edit);
		List<ShopItems> item = itemsDao.findAll();
		return new ModelAndView("/admin-page", "list", item);
	}
	
	@PostMapping("/item-added")
	public ModelAndView itemAddedToCart(ShopItems item, 
			@SessionAttribute(name="profile", required=false) UserProfile user) {	
		ShoppingCart cart = new ShoppingCart();
		if(item.getQuantity() - 1 > -1) {
			cart.setQuantity(cart.getQuantity()+1);
			cart.setItem(item);
			cart.setUser(user);
			item.setQuantity(item.getQuantity()-1);
			itemsDao.update(item);
			cartDao.create(cart);
		}
		List<ShopItems> list = itemsDao.findAll();
		return new ModelAndView("/index", "list", list);
		
	}
}
