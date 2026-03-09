package com.example.fileupload.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fileupload.Entity.Employee;
import com.example.fileupload.Entity.Sales;

@RestController
@RequestMapping("/api/v1/samples")
public class SampleContoller
{

    @PostMapping("/save")
    String saveSamples(){

    	return "saved successfully";
    }
    
    @GetMapping("/get")
    public String getUser() {

    	return "Hoolala!";
	}
    
    
    @GetMapping("/hello")
    public String getHello() {

    	return "Hello!";
	}
    
    @DeleteMapping("/{id}")
    public String getUser(@PathVariable Integer id) {

    	return "Deleted id: "+id;
	}
    
    @PutMapping("/update")
    public String getUser(@RequestBody Employee emp) {

    	return "Hoolala!";
	}
    
}
