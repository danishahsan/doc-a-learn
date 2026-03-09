package com.example.fileupload.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.fileupload.Entity.User;

public interface UserRepository extends JpaRepository<User,String>{

//	@Query("select u from User u where u.username=:username")
	Optional<User> findUserByUsername(String username);
	
}