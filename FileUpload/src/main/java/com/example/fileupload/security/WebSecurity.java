package com.example.fileupload.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.fileupload.Repository.UserRepository;

import lombok.AllArgsConstructor;

@Configuration
//@AllArgsConstructor
public class WebSecurity {

//	UserRepository usersRepo;

//	@Autowired
//	private CustomAuthEntryPoint authEntryPoint;

//	@Bean
	SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
		
		http
		.authorizeHttpRequests(auth -> auth
//				.requestMatchers("/employees/saves").permitAll()  // allow this
//				.requestMatchers(HttpMethod.GET,"/api/v1/user/**").permitAll()
//				.requestMatchers("/api/v1/employees/**","/api/v1/department/**","api/v1/user/**").permitAll()
				.requestMatchers("/api/v1/{var:employees|department}/**").permitAll()
//				.requestMatchers(null)
				.anyRequest().authenticated())
		
		
		.csrf(csrf -> csrf.disable());
		return http.build();
	}
	
//	@Bean
	UserDetailsService getMemoryUserDetailsManager(DataSource datasource ) {
		UserDetails dan = User.withUsername("dan")
		.password("1234")
		.authorities("read","write")
		.build();
		
		UserDetails shan = User.withUsername("shan")
		.password("1234")
		.authorities("write")
		.build();
		
		UserDetails bhim = User.withUsername("bhim")
				.password("1234")
				.authorities("write", "ROLE_ADMIN")
				.build();
		
		return  new InMemoryUserDetailsManager(dan,shan,bhim);

	}

//	@Bean
	JdbcUserDetailsManager getusers(DataSource dataSource) {
		JdbcUserDetailsManager jdbc = new JdbcUserDetailsManager(dataSource);
		
		jdbc.setUsersByUsernameQuery(
                "SELECT username, password, true as enabled FROM users WHERE username = ? and u.password= ?"
        );

//		jdbc.setUsersByUsernameQuery("select u from User where u.username= ? and u.password= ?");
		return jdbc;
	}

	@Bean
	PasswordEncoder setPassword() {

		return NoOpPasswordEncoder.getInstance();
	}

//	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(auth -> auth
				.anyRequest().authenticated()
				);
//		.httpBasic(basic -> basic
//				.authenticationEntryPoint(null) // Use custom entry point // authEntryPoint
//				);
		return http.build();
	}

}
