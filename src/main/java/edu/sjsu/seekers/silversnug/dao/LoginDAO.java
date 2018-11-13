package edu.sjsu.seekers.silversnug.dao;

import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {

	
	public void authenticate(String username) {
		System.out.println("In DAO: " + username);
	}
	
}
