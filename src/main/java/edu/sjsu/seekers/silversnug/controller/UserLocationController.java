package edu.sjsu.seekers.silversnug.controller;

import edu.sjsu.seekers.silversnug.response.UserLocationResponse;
import edu.sjsu.seekers.silversnug.response.UserResponse;
import edu.sjsu.seekers.silversnug.service.UserLocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import edu.sjsu.seekers.silversnug.request.LoginRequest;
import edu.sjsu.seekers.silversnug.request.UserSignupRequest;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import edu.sjsu.seekers.silversnug.response.UserResponse;
import edu.sjsu.seekers.silversnug.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserLocationController {

    @Autowired
    UserLocationService userLocationService;


    @GetMapping("/SilverSnug/User/GetUserLocations")
    public List<UserLocationResponse> getUserLocations(@RequestParam(value="userName") String userName ) {
        return userLocationService.getUserLocations(userName);
    }
}
