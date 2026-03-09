package com.insta.caller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.insta.jdbc.PostTable;

@Component
public class PostCaller {

	@Autowired
	PostTable pt;
	
	
	public void postInsert() throws SQLException {
		pt.insertIntoPost();
	}
}
