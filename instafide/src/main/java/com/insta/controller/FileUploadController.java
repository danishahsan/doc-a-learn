package com.insta.controller;


import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//import com.insta.mySql.service.FileStorageService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/file")
@AllArgsConstructor
public class FileUploadController {

//	FileStorageService fss;
	
	
	@PostMapping("/upload")
	public ResponseEntity<?> save(@RequestParam MultipartFile file) throws IOException{
		
//		return ResponseEntity.status(HttpStatus.CREATED).body(fss.storeFile(file));
//		return ResponseEntity.status(200).body();
		return null;
	}

	
}
