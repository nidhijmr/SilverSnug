package edu.sjsu.seekers.silversnug.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.sjsu.seekers.silversnug.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/login")
    public String index() {
		loginService.authenticate("nidhi");
		return "Hello from Silver Snug!";    
    }
	
}
