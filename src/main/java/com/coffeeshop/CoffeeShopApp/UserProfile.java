package com.coffeeshop.CoffeeShopApp;

public class UserProfile {
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String password;
	
	public UserProfile() {
		// TODO Auto-generated constructor stub
	}

	public UserProfile(String firstName, String lastname, String email, String phonenumber, String password) {
		this.firstName = firstName;
		this.lastName = lastname;
		this.email = email;
		this.phoneNumber = phonenumber;
		this.password = password;
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

}
