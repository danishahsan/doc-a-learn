package com.insta.mySql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insta.mySql.entity.Comment;
import com.insta.mySql.repo.CommentRepo;

@Service
public class CommentService {

	
	@Autowired
	CommentRepo cmr;
	
	public String saveComment(Comment comment) {

		cmr.save(comment);
		return "Comment Saved";
	}
	
	private void updateComment(Long id) {

		Comment cmt = cmr.getReferenceById(id);
		
		cmt.setComment("Revised Comment");
		
		cmr.save(cmt);
	}
}
