package com.ThinkOn.test;

import jakarta.persistence.*;

@Entity
@Table(name = "USERS")
public class User {
	
	// Class attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String username;
	
	private String firstName;
	private String lastName;
	private String email;
	private String phone;

	// Constructors
	public User() {
		// Empty
	}
	
	public User(String username, String firstName, String lastName, String email, String phone) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	// Getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + "]";
	}


}
