package com.insta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.insta.mySql.entity.Post;
import com.insta.mySql.service.PostService;

@RestController
public class PostController {

	@Autowired
	PostService ps;
	
	public String addPost(Post post){
		
		return ps.savePost(post);
	}
}
