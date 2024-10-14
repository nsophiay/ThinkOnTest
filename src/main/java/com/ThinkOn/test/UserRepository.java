package com.ThinkOn.test;

import java.util.HashMap;

public class UserRepository {
	
	private HashMap<String, User> allUsers = new HashMap<String, User>(); // Use HashMap to store users for ease of access

	public UserRepository() {
		// Empty
	}

	// Getters and setters
	public HashMap<String, User> getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(HashMap<String, User> allUsers) {
		this.allUsers = allUsers;
	}
	
	// Add user
	public void addUser(User user) {
		allUsers.put(user.getUsername(), user);
	}

}
