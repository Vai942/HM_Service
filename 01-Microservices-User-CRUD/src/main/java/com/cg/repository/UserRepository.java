package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	//List<User>findAllByUsername(String username);
	@Query("select count(*) from User u where userName=:userName")
	
	int getCountByUser(String userName);

}
