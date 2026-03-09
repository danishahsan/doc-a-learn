package com.example.fileupload.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fileupload.Service.AuthService;
import com.example.fileupload.Util.APIResponse;
import com.example.fileupload.dto.LoginDto;
import com.example.fileupload.dto.UserDTO2;

import io.swagger.v3.oas.models.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

	AuthService auths;
	
	@PostMapping("/register")
	public ResponseEntity<APIResponse<String,String>> register(@RequestBody UserDTO2 user) {

		APIResponse<String,String> result= auths.register(user);
		
		return  result.getStatus()==201 ? ResponseEntity.status(HttpStatus.CREATED).body(result)
				:ResponseEntity.status(HttpStatus.CONFLICT).body(result);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<APIResponse<String,String>> login(@RequestBody LoginDto dto) {
		ApiResponse apiResponse = new ApiResponse();
		return null;
	}
}
