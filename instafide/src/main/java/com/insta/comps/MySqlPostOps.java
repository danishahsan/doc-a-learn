package com.insta.comps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.insta.mySql.entity.Post;
import com.insta.mySql.service.PostService;

@Component
public class MySqlPostOps {
	
	@Autowired
	PostService ps;

	
	public void addAPost() {

//		String res=ps.addPost(new Post(16l,"Loana",0));
//		System.out.println(res);
		
		String res = ps.savePost(new Post("Somrao"));
		System.out.println(res);
	}
	
	
	public void addAllPost() {
		List<Post> posts = List.of(new Post("Mandru"),new Post("Prabha"), 
									new Post("Piku"), new Post("Chamku"),
									new Post("Satty"),new Post("Jenny"),
									new Post("Danal"), new Post("Brews"));
		
		ps.addEachPost(posts);
//		ps.addInBatch(posts);
	}
	
	public void updatePost() {
		
		System.out.println(ps.updatePost(18l));
		System.out.println(ps.updatePostById(18l));
	}
	
	public void deleteAPost() {

		ps.deletePost(18l);
	}
	
	public void deleteAllPost() {

		List<Long> ids = List.of(14l,15l,16l);
		ps.deletePosts(ids);
		
	}
	
	
	public void deletePostsInBatch() {

		List<Long> ids = List.of(14l,15l,16l);
		ps.deletePostInBatch(ids);
	}
	
	public void deleteByTitle() {

		ps.deleteByTitle("paglu");
	}
}
