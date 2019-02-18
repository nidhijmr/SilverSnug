package edu.sjsu.seekers.silversnug.controller;

import edu.sjsu.seekers.silversnug.request.UserSignupRequest;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import edu.sjsu.seekers.silversnug.response.UserResponse;
import edu.sjsu.seekers.silversnug.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping("/login")
    public String login() {
		userService.authenticate("nidhi");
		return "Hello from Silver Snug!";
    }


	@PostMapping("/SilverSnug/User/Signup")
	@ResponseBody
	public GenericResponse signuUpUser(@RequestBody UserSignupRequest request) {
		return userService.saveUser(request);
	}


	@GetMapping("/SilverSnug/User/GetUser")
	public UserResponse getUser(@RequestParam(value="userName") String userName ) {
		return userService.getUserByUserName(userName);
	}

}
