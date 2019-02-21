package com.coffeeshop.CoffeeShopApp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.coffeeshop.CoffeeShopApp.UserProfile;

@Repository
@Transactional
public class UserDao {
	@PersistenceContext
	private EntityManager em;
	
	public void create(UserProfile user) {
		em.persist(user);
	}
}
