package com.insta.mySql.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insta.mySql.entity.Post;


@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

	boolean deleteByTitle(String title);
//	
//	@Modifying
//	@Query("delete from Post where title =:title")
//	void deleteTitle(String title);
	
}
