package com.example.fileupload.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fileupload.Entity.User1;

public interface User_1_Repository extends JpaRepository<User1,String>{

//	@Query("select u from User u where u.username=:username")
	User1 findUser1ByUsername(String username);
	User1 findUser1ByEmail(String email);
	
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);
	
}