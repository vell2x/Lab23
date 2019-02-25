package com.coffeeshop.CoffeeShopApp;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class ShoppingCart {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cart_item_id")
	private int id;
	
	@Column(name="cart_name")
	private String name;
	
	@Column(name="cart_quantity")
	private int quantity;
	
	@Column(name="cart_price")
	private double price;

	@OneToMany(mappedBy = "cart")
	private Set<ShopItems> item;

	public ShoppingCart() {

	}

	public ShoppingCart(String name, int quantity, double price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Set<ShopItems> getItem() {
		return item;
	}

	public void setItem(Set<ShopItems> item) {
		this.item = item;
	}
}
