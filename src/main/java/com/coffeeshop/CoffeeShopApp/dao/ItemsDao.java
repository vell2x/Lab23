package com.coffeeshop.CoffeeShopApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.coffeeshop.CoffeeShopApp.ShopItems;

@Repository
public class ItemsDao {
	@Autowired
	private JdbcTemplate jdbc;

	public List<ShopItems> findAll() {
		String sql = "SELECT * FROM ITEMS";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(ShopItems.class));
	}
}
