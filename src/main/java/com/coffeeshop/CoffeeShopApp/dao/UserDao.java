package com.coffeeshop.CoffeeShopApp.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.coffeeshop.CoffeeShopApp.ShopItems;
import com.coffeeshop.CoffeeShopApp.UserProfile;

@Repository
@Transactional
public class UserDao {
	@PersistenceContext
	private EntityManager em;
	
	public void create(UserProfile user) {
		em.persist(user);
	}
	
	public UserProfile findByUsername(String username) {
		UserProfile user;

		

		try {

			user = (UserProfile) em.createQuery("FROM UserProfile where username = :username")
					.setParameter("username", username).getSingleResult();

		} catch (NoResultException e) {
			user = null;
		}
		return user;

	}
}
