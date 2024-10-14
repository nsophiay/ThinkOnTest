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
	
	// Get specific user
	public User getSpecificUser(String username) {
		return allUsers.containsKey(username) ? allUsers.get(username) : null;
	}
	
	// Add user
	public void addUser(User user) {
		allUsers.put(user.getUsername(), user);
	}
	
	// Remove user
	public boolean removeUser(String username) {
		return allUsers.remove(username) != null ? true : false;
	}

}
