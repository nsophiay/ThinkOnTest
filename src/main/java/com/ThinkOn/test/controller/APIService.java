package com.ThinkOn.test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.ThinkOn.test.User;

@RestController
@RequestMapping("/users")
public class APIService {
	
	User user;

	@GetMapping("/{username}")
	public User getUser(String username) {
		return user;
	}
	
	@GetMapping
	public List<User> getAllUsers() {
		return user.getUsers();
	}
	
	@PostMapping
	public String createUser(@RequestBody User user) {
		this.user = user;
		return "Successfully created user " + user.getUsername();
	}
	
	@PutMapping
	public String updateUser(@RequestBody User user) {
		this.user = user;
		return "Successfully updated user " + user.getUsername();
	}
	
	@DeleteMapping("/{username}")
	public String deleteUser(String username) {
		this.user = null;
		return "Successfully deleted user";
	}
	

}
