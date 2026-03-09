package com.example.fileupload.security;

import org.springframework.security.core.GrantedAuthority;

import com.example.fileupload.Entity.Authority;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class CustomAuthority implements GrantedAuthority{

	private Authority authority;
	
	@Override
	public String getAuthority() {
		return authority.getName();
	}

}
