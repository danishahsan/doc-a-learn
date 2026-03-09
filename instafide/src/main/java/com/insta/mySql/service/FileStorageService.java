package com.insta.mySql.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

	final String drivePath;
	
	public FileStorageService(@Value("${file.upload-dir}") String drivePath) {
		this.drivePath = drivePath;
		
	}
	
	
	
	public String storeFile(MultipartFile file) throws IOException{
		
		Path path = Path.of(drivePath).toAbsolutePath().normalize();
		Files.createDirectories(path);

		String filename = file.getOriginalFilename();
		
		Path target = path.resolve(filename);
		
		Files.copy(file.getInputStream(),target, StandardCopyOption.REPLACE_EXISTING);
		return null;
	}
}
