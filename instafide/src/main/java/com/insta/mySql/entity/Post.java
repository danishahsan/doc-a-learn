package com.insta.mySql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity(name= "mySqlPost")
@Table(name = "post")
public class Post {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String title;
	
	@Version
	Integer version;
	
	

	
	public Post() {
		super();
	}


	public Post( String title) {
		super();
		this.title = title;
	}
	public Post(Long id, String title, int version) {
		super();
		this.id = id;
		this.title = title;
		this.version = version;
	}
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


}
