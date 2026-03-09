package com.insta.comps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.insta.postgre.entity.Post;
import com.insta.postgre.service.PostService;

@Component
public class PostgrePostOps {
	
	@Autowired
	PostService ps;

	
	public void addAPost() {

		System.out.println("control in PostgrePostOps");
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
