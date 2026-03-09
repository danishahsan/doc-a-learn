package com.insta.controller;



import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.insta.config.PolarProp;
import com.insta.mySql.service.FileStorageService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/demo")
@AllArgsConstructor

public class DemoController {

	PolarProp prop;
	

	@GetMapping("/")
	public String gets(){
//	Header versioning
	return "Welcome to the "+ prop.greeting +"!";
	}
	
}
