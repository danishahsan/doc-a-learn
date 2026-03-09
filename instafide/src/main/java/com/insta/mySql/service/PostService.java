package com.insta.mySql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.insta.mySql.entity.Post;
import com.insta.mySql.repo.PostRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;

@Service
public class PostService {

	@Autowired
	PostRepo postRepo;
	
	@Autowired
	EntityManager em;
	
	public String savePost(Post post) {

		postRepo.save(post);
		return "saved successfully";
	} 
	
	
	@Transactional
	public void addEachPost(List<Post> posts) {

//		postRepo.saveAll(posts);
		
		for (Post post : posts) {
			em.persist(post);
		}
		
		
		System.out.println("Added Successfully");
	}
	
	
	public void addInBatch(List<Post> posts) {

		postRepo.saveAllAndFlush(posts);
		
		System.out.println("Added Successfully");
	}
	
	
	@Transactional
	public String updatePost(Long id) {

		Post ref = postRepo.getReferenceById(id);
		
		ref.setTitle("Adam");
		postRepo.save(ref);
		
		return "updated successfully";
	}
	
	
	public String updatePostById(Long id) {
		Optional<Post> dem = postRepo.findById(id);
		System.out.println("fetched");
		
		Post po = dem.get();
		
//		po.setTitle("Sukhi");
		po=new Post("Delulu");
		postRepo.save(po);
		
		return "updated successfully";
	}
	
	public void deletePost(Long id) {

		Post ref = postRepo.getReferenceById(id);
		
		System.out.println(em.contains(ref));
		
//		ref is a detached entity
		postRepo.delete(ref);
		System.out.println("Post successfully Deleted");
	}
	
	@Modifying
	public void deletePosts(List<Long> ids) {

		postRepo.deleteAllById(ids);
		System.out.println("Deleted Successfully");
	}
	
	public void deletePostInBatch(List<Long> ids) {

		postRepo.deleteAllByIdInBatch(ids);
		System.out.println("Deleted Successfully");
	}
	
	@Transactional
	public void deleteByTitle(String title) {
		
//		It fetches the instance from DB then deletes it. deletion happens on server that is reflected to DB.
		postRepo.deleteByTitle(title);
		
//		Delete operation directly takes place in DB.
//		postRepo.deleteTitle(title);
		System.out.println("Deleted Successfully");
	}

}