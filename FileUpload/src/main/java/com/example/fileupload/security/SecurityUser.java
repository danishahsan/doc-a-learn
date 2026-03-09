package com.example.fileupload.security;

import com.example.fileupload.Entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class SecurityUser implements UserDetails{

	private User user;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(()->"read");
	}

	@Override
	public String getPassword() {
		return  user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}


//	public SecurityUser() {
//		super();
//	}

//	public SecurityUser(User user) {
//		super();
//		this.user = user;
//	}

	
}