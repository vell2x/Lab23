package com.coffeeshop.CoffeeShopApp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserProfile {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id") // name of SQL column
	private int id;
	
	private String username;

	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	private String email;
	
	@Column(name="phonenumber")
	private String phoneNumber;
	
	private String password;
	
	@OneToMany(mappedBy = "user")
    private List<ShoppingCart> cart = new ArrayList<ShoppingCart>();
	
	public UserProfile() {
		// TODO Auto-generated constructor stub
	}

	public UserProfile(int id, String firstName, String lastname, String email, String phonenumber, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastname;
		this.email = email;
		this.phoneNumber = phonenumber;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phonenumber) {
		this.phoneNumber = phonenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserProfile [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", password=" + password + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<ShoppingCart> getCart() {
		return cart;
	}

	public void setCart(List<ShoppingCart> cart) {
		this.cart = cart;
	}

}
