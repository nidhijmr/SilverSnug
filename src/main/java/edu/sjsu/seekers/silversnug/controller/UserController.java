package edu.sjsu.seekers.silversnug.controller;

import edu.sjsu.seekers.silversnug.request.LoginRequest;
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

	@PostMapping("/SilverSnug/User/login")
	@ResponseBody
    public UserResponse login(@RequestBody LoginRequest request) {
		return userService.authenticate(request);
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


	@PostMapping("/SilverSnug/User/EditUser")
	@ResponseBody
	public GenericResponse editUser(@RequestBody UserSignupRequest request) {
		return userService.editUser(request);
	}

}
