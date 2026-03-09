package com.example.fileupload.security;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException ex) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setContentType("application/json");
		
		response.getWriter().write("""
				{
					 "status": 401,
				     "error": "UNAUTHORIZED",
				     "message": "%s",
				     "path": "%s"
				}
				""".formatted(ex.getLocalizedMessage(), ex.getAuthenticationRequest()));
	}

}
