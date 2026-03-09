package com.example.fileupload.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppSecurityConfig {

	
	@Bean
	SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
		
		http
		.authorizeHttpRequests(auth -> auth
//				.requestMatchers("/employees/saves").permitAll()  // allow this
//				.requestMatchers(HttpMethod.GET,"/api/v1/user/**").permitAll()
//				.requestMatchers("/api/v1/employees/**","/api/v1/department/**","api/v1/user/**").permitAll()
				.requestMatchers("/api/v1/{var:employees|department|auth}/**").permitAll()
//				.requestMatchers(null)
				.anyRequest().authenticated())
		
		
		.csrf(csrf -> csrf.disable());
		return http.build();
	}
}
