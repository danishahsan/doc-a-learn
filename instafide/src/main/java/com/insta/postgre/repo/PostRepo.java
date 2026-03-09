package com.insta.postgre.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insta.postgre.entity.Post;



@Repository("postgreRepo")
public interface PostRepo extends JpaRepository<Post, Long> {

//	void deleteByTitle(String title);
	
//	@Modifying
//	@Query("delete from Post where title =:title")
//	void deleteTitle(String title);
	
}
