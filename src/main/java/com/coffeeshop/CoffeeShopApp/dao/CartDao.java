package com.coffeeshop.CoffeeShopApp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.coffeeshop.CoffeeShopApp.ShoppingCart;

@Repository
@Transactional
public class CartDao {
	@PersistenceContext
	private EntityManager em;

	public List<ShoppingCart> findAll() {
		return em.createQuery("FROM ShopItems", ShoppingCart.class).getResultList();
	}
	
	public ShoppingCart findById(int id) {
		return em.find(ShoppingCart.class, id);
	}
	
	public void update(ShoppingCart cart) {
		em.merge(cart);
	}
	
	public void create(ShoppingCart cart) {
		em.persist(cart);
	}
	
	public void delete(int id) {
		ShoppingCart cart = em.getReference(ShoppingCart.class, id);
		em.remove(cart);
	}
}
