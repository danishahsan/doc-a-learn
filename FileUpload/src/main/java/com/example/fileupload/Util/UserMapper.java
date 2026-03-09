package com.example.fileupload.Util;

import com.example.fileupload.Entity.User;
import com.example.fileupload.dto.UserDTO;

public class UserMapper {

	
	public static User getUser(UserDTO user) {
		User user2 = new User();
		user.setUsername(user.getUsername());
		user.setPassword(user.getPassword());
		return user2;
	}
}
