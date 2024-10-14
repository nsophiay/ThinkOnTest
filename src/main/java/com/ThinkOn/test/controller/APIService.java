package com.ThinkOn.test.controller;

import java.util.HashMap;

import org.hibernate.SessionFactory;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.web.bind.annotation.*;

import com.ThinkOn.test.User;
import com.ThinkOn.test.UserRepository;

@RestController
@RequestMapping("/users")
public class APIService {
	
	private SessionFactory sessionFactory;
	
	private UserRepository users;
	
	public APIService() {
		users = new UserRepository();
	}

	@GetMapping("/{username}") // List a single user
	public String getUser(@PathVariable String username) {
		
		User requestedUser = users.getAllUsers().get(username);
		
		// Check if user exists
		if(requestedUser != null) {
			// If so, return the requested user
			return requestedUser.toString();
		}
		else {
			return "Cannot find user " + username;
		}
		
	}
	
	@GetMapping // List all users
	public HashMap<String, User> getUsers(String username) {
		return users.getAllUsers();
	}
	
	@PostMapping // Create a user
	public String createUser(@RequestBody User user) {
		this.users.getAllUsers().put(user.getUsername(), user);
		return "Successfully created user " + user.getUsername();
	}
	
	@PutMapping // Update a user
	public String updateUser(@RequestBody User user) {
		users.getAllUsers().replace(user.getUsername(), user);
		return "Successfully updated user " + user.getUsername();
	}
	
	@DeleteMapping("{username}") // Delete a user
	public String deleteUser(String username) {
		users.getAllUsers().remove(username);
		return "Successfully deleted user";
	}
	
    @BeforeEach
    protected void setUp() throws Exception {
	   // A SessionFactory is set up once for an application!
	   final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			 .configure() // configures settings from hibernate.cfg.xml
			 .build();
	   try {
		  sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	   }
	   catch (Exception e) {
		  // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
		  // so destroy it manually.
		  StandardServiceRegistryBuilder.destroy( registry );
	   }
    }

    @AfterEach
    protected void tearDown() throws Exception {
	   if ( sessionFactory != null ) {
		  sessionFactory.close();
	   }
    }
	

}
