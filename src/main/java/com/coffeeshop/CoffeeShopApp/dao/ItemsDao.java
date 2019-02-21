package com.coffeeshop.CoffeeShopApp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.coffeeshop.CoffeeShopApp.ShopItems;
import com.coffeeshop.CoffeeShopApp.UserProfile;

@Repository
@Transactional
public class ItemsDao {
	@PersistenceContext
	private EntityManager em;

	public List<ShopItems> findAll() {
		return em.createQuery("FROM ShopItems", ShopItems.class).getResultList();
	}
	
	public void update(ShopItems item) {
		em.merge(item);
	}
	
	public void create(ShopItems item) {
		em.persist(item);
	}
	
	public void delete(int id) {
		ShopItems item = em.getReference(ShopItems.class, id);
		em.remove(item);
	}
}
