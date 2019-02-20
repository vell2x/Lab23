package com.coffeeshop.CoffeeShopApp;

public class ShopItems {
	private String itemName;
	private String itemDescription;
	private int itemQuantity;
	private double itemPrice;
	
	public ShopItems() {
		// TODO Auto-generated constructor stub
	}

	public ShopItems(String itemName, String itemDescription, int itemQuantity, double itemPrice) {
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemQuantity = itemQuantity;
		this.itemPrice = itemPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "ShopItems [itemName=" + itemName + ", itemDescription=" + itemDescription + ", itemQuantity="
				+ itemQuantity + ", itemPrice=" + itemPrice + "]";
	}

}
