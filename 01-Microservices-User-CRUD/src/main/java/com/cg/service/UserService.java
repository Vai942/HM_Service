package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.User;
import com.cg.repository.UserRepository;

import jakarta.validation.Valid;

@Service
public class UserService implements IUserService {
	
	@Autowired
	UserRepository userrepo;

	/*@Override
	public List<User> getUserByusername(String username) {
		
		return userrepo.findAllByUsername(username);
	}*/
	
	@Override
	public List<User> findAllUsers(){
		 return userrepo.findAll();
	}

	@Override
	public Optional<User> findUserById(int uid) {
		
		return userrepo.findById(uid);
	}

	@Override
	public User createUser(@Valid User usr) {
		
		return userrepo.save(usr);
	}

	

	@Override
	public User updateUser(User u) {
		
		return userrepo.save(u);
	}

	@Override
	public int getCountByUser(String userName) {
		// TODO Auto-generated method stub
		return userrepo.getCountByUser(userName);
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		 userrepo.deleteById(id);
		return false;
	}

}
