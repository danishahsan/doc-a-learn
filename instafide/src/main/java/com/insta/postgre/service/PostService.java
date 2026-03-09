package com.insta.postgre.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insta.postgre.entity.Post;
import com.insta.postgre.repo.PostRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;

@Service("postgreService")
public class PostService {

	@Autowired
	PostRepo postRepo;
	
	@PersistenceContext(unitName = "postgreDb")
	EntityManager em;
	
	@PersistenceUnit(name = "postgreEntityManager")
	EntityManagerFactory ef;
	
	public String savePost(Post post) {

		System.out.println("saving Post");
//		postRepo.save(post);
		em.persist(post);
		
		return "saved successfully";
	} 
	
	public void addEachPost(List<Post> posts) {

		postRepo.saveAll(posts);
		
		
		
		System.out.println("Added Successfully");
	}
	
	@Transactional(transactionManager = "postgreTransaction")
	public void addInBatch(List<Post> posts) {

		for (int i = 0; i < posts.size(); i++) {
			
			em.persist(posts.get(i));
			
			if(i>0 && i%4==0) {
				em.flush();
				em.clear();
			}
		}
		em.flush();
		em.clear();
		
		batchCount();
		System.out.println("Added Successfully");
	}
	
	public void batchCount() {

		SessionFactory sf = ef.unwrap(SessionFactory.class);
		System.out.println("JDBC batch count: " + sf.getStatistics().getEntityInsertCount());
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
//		postRepo.deleteByTitle(title);
		
//		Delete operation directly takes place in DB.
//		postRepo.deleteTitle(title);
		System.out.println("Deleted Successfully");
	}

}