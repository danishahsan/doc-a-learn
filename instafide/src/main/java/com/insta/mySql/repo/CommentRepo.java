package com.insta.mySql.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insta.mySql.entity.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Long>{

}
