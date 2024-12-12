package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.model.User;

public interface IUserService {

	List<User> findAllUsers();
	//List<User> getUserByusername(String username);

	Optional<User> findUserById(int id);

	User createUser(User usr);

	
	User updateUser(User u);

	int getCountByUser(String username);

	boolean deleteUser(int id);

}
