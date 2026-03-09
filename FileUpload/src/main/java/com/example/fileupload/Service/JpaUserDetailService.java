package com.example.fileupload.Service;

import com.example.fileupload.Entity.User;
import com.example.fileupload.Repository.UserRepository;
import com.example.fileupload.security.SecurityUser;

import lombok.AllArgsConstructor;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class JpaUserDetailService implements UserDetailsService {

	UserRepository userRepo;
	
//	JdbcUserDetailsManager jdbc;
	
	@Override
	public UserDetails loadUserByUsername(String username) {

		Optional<User> user = userRepo.findUserByUsername(username);
		return user.map(SecurityUser::new)
				.orElseThrow(()-> new BadCredentialsException("User not found "+ username));
		
//		return jdbc.loadUserByUsername(username);
	}
	
}