package com.example.fileupload.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeResDTO {

	Long id;
	String firstName;
	String lastName;
	String email;
	String gender;
//	String jobTitle;
	
}
