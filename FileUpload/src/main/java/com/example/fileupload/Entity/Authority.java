package com.example.fileupload.Entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="authorities")
public class Authority {

	@Id
	Integer id;
	
	String name;
	
	@ManyToMany(mappedBy = "authorities")
	Set<User> users;
}
