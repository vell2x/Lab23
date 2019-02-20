package com.coffeeshop.CoffeeShopApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.coffeeshop.CoffeeShopApp.UserProfile;

@Repository
public class CustomerList {
	@Autowired
	private JdbcTemplate jdbc;
	
	public void create(UserProfile user) {
		String sql = "INSERT INTO USERS (firstname, lastname, email, phonenumber, password) VALUES (?, ?, ?, ?, ?)";
		jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(), user.getPassword());
	}
}
