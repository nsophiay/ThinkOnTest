package com.ThinkOn.test.controller;

import java.util.HashMap;
import org.springframework.web.bind.annotation.*;

import com.ThinkOn.test.User;
import com.ThinkOn.test.UserRepository;

@RestController
@RequestMapping("/users")
public class APIService {
	
	private UserRepository users;
	
	public APIService() {
		users = new UserRepository();
	}

	@GetMapping("/{username}") // List a single user
	public String getUser(@PathVariable String username) {
		
		User requestedUser = users.getSpecificUser(username);
		return requestedUser != null ? requestedUser.toString() : "Cannot find user " + username;
		
	}
	
	@GetMapping // List all users
	public HashMap<String, User> getUsers(String username) {
		return users.getAllUsers();
	}
	
	@PostMapping // Create a user
	public String createUser(@RequestBody User user) {
		this.users.addUser(user);
		return "Successfully created user " + user.getUsername();
	}
	
	@PutMapping // Update a user
	public String updateUser(@RequestBody User user) {
		HashMap<String, User> listOfUsers = users.getAllUsers();
		
		// Check if user exists before attempting to update
		if (listOfUsers.containsKey(user.getUsername())) listOfUsers.replace(user.getUsername(), user);
		else return "Could not find user " + user.getUsername();
		return "Successfully updated user " + user.getUsername();
	}
	
	@DeleteMapping("/{username}") // Delete a user
	public String deleteUser(@PathVariable String username) {
		return users.removeUser(username) ? "Successfully deleted user" : "Could not find user " + username;
	}
	

}
