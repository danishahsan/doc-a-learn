package com.example.fileupload.Entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="users")
public class User {

//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	Integer id;
	@Id
	String username;
	String password;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "users_authorities", 
				joinColumns = @JoinColumn(name="user_username"),
				inverseJoinColumns = @JoinColumn(name="authority_id"))
	Set<Authority> authorities;
	
	/*
	 * public String getUsername() { return this.username; }
	 * 
	 * 
	 * public Integer getId() { return id; }
	 * 
	 * 
	 * public void setId(Integer id) { this.id = id; }
	 * 
	 * 
	 * 
	 * public String getPassword() { return password; }
	 * 
	 * 
	 * public void setPassword(String password) { this.password = password; }
	 * 
	 * 
	 * public void setUsername(String username) { this.username = username; }
	 * 
	 * 
	 * public Set<Authority> getAuthorities() { return authorities; }
	 * 
	 * 
	 * public void setAuthorities(Set<Authority> authorities) { this.authorities =
	 * authorities; }
	 */
	
}
