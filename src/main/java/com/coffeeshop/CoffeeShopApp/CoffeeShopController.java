package com.coffeeshop.CoffeeShopApp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView showAdminPage() {
		List<ShopItems> item = itemsDao.findAll();
		return new ModelAndView("/admin-page", "list", item);
	}
	
	@RequestMapping("/registration")
	public ModelAndView showRegistrationPage() {
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
		ShoppingCart cart = new ShoppingCart();
		cart.setName(item.getName());
		cart.setPrice(item.getPrice());
		ModelAndView mav = new ModelAndView("cart-page");
		mav.addObject("object", item);
		mav.addObject("cartItem", cart);
		return mav;
	}
	
	@PostMapping("/remgistered")
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
	
	@PostMapping("/admin-edit")
	public ModelAndView editItem(ShopItems edit) {	
		itemsDao.update(edit);
		List<ShopItems> item = itemsDao.findAll();
		return new ModelAndView("/admin-page", "list", item);
	}
	
	@PostMapping("/item-added")
	public ModelAndView itemAddedToCart(ShoppingCart purchase) {	
		if(purchase.getQuantity() - 1 > 0) {
			//purchase.setQuantity(purchase.getQuantity()-1);
			
		}
		cartDao.create(purchase);
		List<ShopItems> item = itemsDao.findAll();
		return new ModelAndView("/index", "list", item);
	}
}
