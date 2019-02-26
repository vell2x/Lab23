package com.coffeeshop.CoffeeShopApp;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class ShoppingCart {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cart_item_id")
	private int id;
	
	@Column(name="cart_quantity")
	private int quantity;

	@ManyToOne
	private ShopItems item;
	
	@ManyToOne
	private UserProfile user;

	public ShoppingCart() {
	
	}
	
	public ShoppingCart(int id, int quantity, ShopItems item, UserProfile user) {
		this.id = id;
		this.quantity = quantity;
		this.item = item;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ShopItems getItem() {
		return item;
	}

	public void setItem(ShopItems item) {
		this.item = item;
	}

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

}
