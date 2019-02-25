package com.coffeeshop.CoffeeShopApp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class ShopItems {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="item_id")
	private int id;
	private String name;
	private String description;
	private int quantity;
	private double price;
	
	@ManyToOne
	private ShoppingCart cart;
	
	public ShopItems() {
		// TODO Auto-generated constructor stub
	}

	public ShopItems(int id, String name, String description, int quantity, double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	@Override
	public String toString() {
		return "ShopItems [itemName=" + name + ", itemDescription=" + description + ", itemQuantity="
				+ quantity + ", itemPrice=" + price + "]";
	}
}
