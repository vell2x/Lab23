package com.coffeeshop.CoffeeShopApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CustomerList {
	private ArrayList<UserProfile> users = new ArrayList<>();
	public CustomerList() {
		// TODO Auto-generated constructor stub
	}
	
	public List<UserProfile> getAllCustomers() {
		return users;
	}
	
	public void addCustomer(UserProfile user) {
		users.add(user);
	}
	
	public void addCustomer(String firstName, String lastName, String email, int phoneNumber, String password) {
		UserProfile user = new UserProfile(firstName, lastName, email, phoneNumber, password);
		users.add(user);
	}

}
