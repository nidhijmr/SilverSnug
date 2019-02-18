package edu.sjsu.seekers.silversnug.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.sjsu.seekers.silversnug.dao.LoginDAO;

@Service
public class LoginService {

	@Autowired
	LoginDAO loginDAO;

	public void authenticate(String username) {
		System.out.println("In service: " + username);
		loginDAO.authenticate(username);
	}
	
}
