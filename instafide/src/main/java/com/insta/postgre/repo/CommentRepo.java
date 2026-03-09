package com.insta.postgre.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insta.postgre.entity.Comment;


@Repository("postgreCommentRepo")
public interface CommentRepo extends JpaRepository<Comment,Long>{

}
