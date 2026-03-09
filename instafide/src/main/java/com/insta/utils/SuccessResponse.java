package com.insta.utils;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
public class SuccessResponse {

	HttpStatus status;
	String messeage;
	String path;
}
