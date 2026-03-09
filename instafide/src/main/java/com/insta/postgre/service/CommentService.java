package com.insta.postgre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insta.postgre.entity.Comment;
import com.insta.postgre.repo.CommentRepo;


@Service("postgreCommentService")
public class CommentService {

	
	@Autowired
	CommentRepo cmr;
	
	public String saveComment(Comment comment) {

//		cmr.save(comment);
		return "Comment Saved";
	}
	
	private void updateComment(Long id) {

//		Comment cmt = cmr.getReferenceById(id);
		
//		cmt.setComment("Revised Comment");
		
//		cmr.save(cmt);
	}
}
