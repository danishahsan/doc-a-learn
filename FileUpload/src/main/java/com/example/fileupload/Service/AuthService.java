package com.example.fileupload.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.fileupload.Entity.User1;
import com.example.fileupload.Repository.User_1_Repository;
import com.example.fileupload.Util.APIResponse;
import com.example.fileupload.dto.UserDTO2;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {

	PasswordEncoder encoder;
	
	User_1_Repository repo;
	
	public APIResponse<String,String> register(UserDTO2 user) {

		if(repo.existsByEmail(user.getEmail())) {
			APIResponse<String,String> response = new APIResponse<>();
			response.setMessage("Registration Failed");
			response.setStatus(409);
			response.getData().put("status: ", "User with username exists");
			return response;
		}
		
		if(repo.existsByUsername(user.getUsername())) {
			APIResponse<String,String> response = new APIResponse<>();
			response.setMessage("Registration Failed");
			response.setStatus(409);
			response.getData().put("status: ","User with Email Id exists");
			return response;
		}
		
		User1 usr = new User1();
		BeanUtils.copyProperties(user, usr);
		usr.setPassword(encoder.encode(user.getPassword()));
		
		User1 save = repo.save(usr);	
		
		APIResponse<String,String> response = new APIResponse<>();
		response.setMessage("Registration Done");
		response.setStatus(201);
		response.getData().put("status: ","User is registered");
		return response;
	}
}
