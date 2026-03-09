package com.insta;

import java.sql.SQLException;
import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.insta.comps.MySqlPostOps;
import com.insta.comps.PostgrePostOps;
import com.insta.mySql.entity.Comment;
import com.insta.mySql.entity.Post;
import com.insta.mySql.service.CommentService;
import com.insta.mySql.service.PostService;

@SpringBootApplication
public class InstafideApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstafideApplication.class, args);
	}

	
	/*
	 * @Bean ApplicationRunner executePost(PostCaller pc) throws SQLException {
	 * 
	 * pc.postInsert(); return ars->{}; }
	 */
	
//	MYSQL
	@Bean
	ApplicationRunner posts(MySqlPostOps po) {
		
//		po.addAPost();
		po.addAllPost();
//		po.updatePost();
		
//		po.deleteAPost();
//		po.deleteAllPost();
//		po.deletePostsInBatch();
//		po.deleteByTitle();
		
		
		return args->{};
		
	}
	
	
	
//	POSTGRE
//	@Bean
	ApplicationRunner posts(PostgrePostOps po) {
		
		po.addAPost();
//		po.addAllPost();
//		po.updatePost();
		
//		po.deleteAPost();
//		po.deleteAllPost();
//		po.deletePostsInBatch();
//		po.deleteByTitle();
		
		
		return args->{};
		
	}
//	@Bean
	ApplicationRunner SaveComment(CommentService cs) {
		
//		Save Comment
//		String res = cs.saveComment(new Comment("Drona"));
//		System.out.println(res);
		
//		Update Comment
		
		return args->{};
		
	}
	
}