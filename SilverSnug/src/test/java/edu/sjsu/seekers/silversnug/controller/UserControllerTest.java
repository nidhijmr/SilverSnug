package edu.sjsu.seekers.silversnug.controller;

import edu.sjsu.seekers.silversnug.request.LoginRequest;
import edu.sjsu.seekers.silversnug.request.UserSignupRequest;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import edu.sjsu.seekers.silversnug.response.UserResponse;
import edu.sjsu.seekers.silversnug.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class UserControllerTest {

    public static final String USER_NAME = "nidhi";
    @MockBean
    UserService userService;

    UserResponse userResponse, userResponseFinal;

    UserController userController;

    GenericResponse genericResponse, genericResponseFinal;

    @Before
    public void setup()
    {
        System.out.println("Setting up test");
        userResponse = new UserResponse("200", "success", "nidhi", "3c58af25-49c0-4736-80c0-e2c074b936d2", "nidhi.jmr1@gmail.com", "6693007100", "Nidhi", "Jamar", "1234",  "6693007100", "profileImage", "patient1");
        genericResponse = new GenericResponse("200","success");
        userController = new UserController();
        userController.userService = mock(UserService.class);
    }

    @Test
    public void login() {

        LoginRequest loginRequest = mock(LoginRequest.class);
        when(userController.userService.authenticate(loginRequest)).thenReturn(userResponse);

        userResponseFinal = userController.login(loginRequest);


        assertEquals(userResponseFinal.getEmailId(),userResponse.getEmailId());
        assertEquals(userResponseFinal.getFirstName(),userResponse.getFirstName());

    }




    @Test
    public void signuUpUser() {
        UserSignupRequest userSignupRequest = mock(UserSignupRequest.class);
        when(userController.userService.saveUser(userSignupRequest)).thenReturn(genericResponse);

        genericResponseFinal = userController.signuUpUser(userSignupRequest);

        assertEquals(genericResponseFinal.getMessage(),genericResponse.getMessage());
        assertEquals(genericResponseFinal.getStatus(),genericResponse.getStatus());

    }

    @Test
    public void getUser() {
        when(userController.userService.getUserByUserName(USER_NAME)).thenReturn(userResponse);

        userResponseFinal = userController.getUser(USER_NAME);


        assertEquals(userResponseFinal.getEmailId(),userResponse.getEmailId());
        assertEquals(userResponseFinal.getFirstName(),userResponse.getFirstName());

    }

    @Test
    public void editUser() {
        UserSignupRequest userSignupRequest = mock(UserSignupRequest.class);
        when(userController.userService.editUser(userSignupRequest)).thenReturn(genericResponse);

        genericResponseFinal = userController.editUser(userSignupRequest);

        assertEquals(genericResponseFinal.getMessage(),genericResponse.getMessage());
        assertEquals(genericResponseFinal.getStatus(),genericResponse.getStatus());
    }
}