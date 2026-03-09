package com.example.fileupload.Controller;

import com.example.fileupload.Entity.User;
import com.example.fileupload.Util.UserMapper;
import com.example.fileupload.dto.EmployeResDTO;
import com.example.fileupload.dto.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {


	@GetMapping
    public String getUsers() {

        return "Successfully saved";
    }


//    @PostMapping
	public ResponseEntity<UserDTO> saveAUser(@RequestBody UserDTO user) {
			User user2 = UserMapper.getUser(user);
		return  ResponseEntity.ok().body(user);
	}
	
    
    @DeleteMapping
    public String deleteUser() {

    	return "User Deleted";
	}
}