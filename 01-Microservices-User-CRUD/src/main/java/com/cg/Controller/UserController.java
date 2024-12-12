package com.cg.Controller;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.MethodNotAllowedException;

import com.cg.exception.ResourceNotFoundException;

import com.cg.model.User;
import com.cg.service.IUserService;

import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("/api")
@RestController
public class UserController {
	
	@Autowired
	IUserService userservice;
	
	// Injecting error messages from application.properties
	@Value("${error.userNotFound}")
    private String userNotFoundMessage;
	
	@Value("${error.userDeletionFailed}")
    private String userDeletionFailedMessage;
	
//	@GetMapping(path = "/users", produces = {MediaType.APPLICATION_JSON_VALUE})
//	public List<User> getUsers(){
//		return userservice.findAllUsers();
//	}
	
	@GetMapping(path = "/users", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<User> getUsers(HttpServletRequest request) throws MethodNotAllowedException {
	    // Check if the HTTP method is GET
	    if (!"GET".equalsIgnoreCase(request.getMethod())) {
	        throw new MethodNotAllowedException("Method " + request.getMethod() + " is not allowed on this endpoint.", null);
	    }

	    // Retrieve and return the list of users
	    return userservice.findAllUsers();
	}
	
	
	@PostMapping("/users")
    public User createUser(@Valid @RequestBody User user, HttpServletRequest request) throws MethodNotAllowedException {
        // Check if the HTTP method is POST
        if (!"POST".equalsIgnoreCase(request.getMethod())) {
            throw new MethodNotAllowedException("Method " + request.getMethod() + " is not allowed on this endpoint.", null);
        }
 
        // Save the user (assuming createUser method saves the User entity to the database)
        User createdUser = userservice.createUser(user);
        // Return the created user entity directly
        return createdUser;
    }
		

	
	@GetMapping("/users/{id}")
	public Optional<User>findByUserId(@PathVariable int id) throws ResourceNotFoundException
	{
		Optional<User> user = userservice.findUserById(id);
		if(user.isEmpty()) {
			throw new ResourceNotFoundException(String.format(userNotFoundMessage, id));
		}
		return user;
	}
	
//	@PostMapping("/users")
//	
//	User createMyUser(@RequestBody User usr) {
//		return userservice.createUser(usr);
//	}
	
	
//	@DeleteMapping("/users/{id}")
//	public void deleteMyUser(@PathVariable int id) {
//		userservice.deleteUser(id);
//	}
	
	@DeleteMapping("/users/{id}")
	public void deleteMyUser(@PathVariable int id) throws ResourceNotFoundException {
		boolean isDeleted = userservice.deleteUser(id);
		if(!isDeleted) {
			throw new ResourceNotFoundException(String.format(userDeletionFailedMessage, id));
		}
		
	}
	
	
	
//	@PutMapping("/users")
//	public User updateMyUser(@RequestBody User u) {
//		return userservice.updateUser(u);
//	}
	@PutMapping("/users")
	public User updateMyUser (@RequestBody User u, HttpServletRequest request) throws MethodNotAllowedException {
	    // Check if the HTTP method is PUT
	    if (!"PUT".equalsIgnoreCase(request.getMethod())) {
	        throw new MethodNotAllowedException("Method " + request.getMethod() + " is not allowed on this endpoint.", null);
	    }

	    // Update the user
	    return userservice.updateUser (u);
	}
	
	@GetMapping(path="/users/count/{userName}")
	public int getCountByUser(@PathVariable String userName) {
		return userservice.getCountByUser(userName);
	}
	

	}
	

