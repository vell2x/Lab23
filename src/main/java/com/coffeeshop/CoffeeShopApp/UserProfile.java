package com.coffeeshop.CoffeeShopApp;

public class UserProfile {
	private String firstname;
	private String lastname;
	private String email;
	private String phonenumber;
	private String password;
	
	public UserProfile() {
		// TODO Auto-generated constructor stub
	}

	public UserProfile(String firstname, String lastname, String email, String phonenumber, String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phonenumber;
	}

	public void setPhoneNumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserProfile [firstName=" + firstname + ", lastName=" + lastname + ", email=" + email + ", phoneNumber="
				+ phonenumber + ", password=" + password + "]";
	}

}
