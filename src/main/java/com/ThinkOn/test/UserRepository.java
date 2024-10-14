package com.ThinkOn.test;

import java.util.HashMap;

public class UserRepository {
	
	private HashMap<String, User> allUsers = new HashMap<String, User>();

	public UserRepository() {
		// TODO Auto-generated constructor stub
	}

	public HashMap<String, User> getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(HashMap<String, User> allUsers) {
		this.allUsers = allUsers;
	}
	
	public void addUser(User user) {
		allUsers.put(user.getUsername(), user);
	}

}
