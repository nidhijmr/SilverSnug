package edu.sjsu.seekers.silversnug.service;

import edu.sjsu.seekers.silversnug.dao.UserDAO;
import edu.sjsu.seekers.silversnug.model.User;
import edu.sjsu.seekers.silversnug.request.LoginRequest;
import edu.sjsu.seekers.silversnug.request.UserSignupRequest;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import edu.sjsu.seekers.silversnug.response.UserResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static edu.sjsu.seekers.silversnug.util.Constants.USER_ADD_SUCCESS;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {


    public static final String USER_NAME = "nidhi";
    UserService userService;
    UserResponse userResponse, userResponseFinal;
    UserSignupRequest userSignupRequest;
    User user;
    GenericResponse genericResponse;

    @Before
    public void setup()
    {
        userService = new UserService();
        user = new User("nidhi", "3c58af25-49c0-4736-80c0-e2c074b936d2", "nidhi.jmr1@gmail.com", "6693007100", "Nidhi", "Jamar", "1234",  "6693007100", "profileImage", "patient1");
        userSignupRequest = new UserSignupRequest("nidhi", "3c58af25-49c0-4736-80c0-e2c074b936d2", "nidhi.jmr1@gmail.com", "6693007100", "Nidhi", "Jamar", "1234",  "6693007100", "profileImage", "patient1");
        userService.userDAO = mock(UserDAO.class);
    }


    @Test
    public void authenticate() {

        LoginRequest loginRequest = mock(LoginRequest.class);
        when(userService.userDAO.authenticate(loginRequest)).thenReturn(user);
        userResponseFinal = userService.authenticate(loginRequest);

        assertEquals(userResponseFinal.getEmailId(),user.getEmailId());
        assertEquals(userResponseFinal.getFirstName(),user.getFirstName());

    }

    @Test
    public void saveUser() {
        when(userService.userDAO.getUserByUserName(user.getUserName())).thenReturn(null);
        userService.userDAO = mock(UserDAO.class);
        genericResponse = userService.saveUser(userSignupRequest);

        assertEquals(genericResponse.getMessage(),USER_ADD_SUCCESS);
        assertEquals(genericResponse.getStatus(), HttpStatus.CREATED.toString());

    }

    @Test
    public void getUserByUserName() {
        when(userService.userDAO.getUserByUserName(USER_NAME)).thenReturn(user);
        userResponseFinal = userService.getUserByUserName(USER_NAME);

        assertEquals(userResponseFinal.getEmailId(),user.getEmailId());
        assertEquals(userResponseFinal.getFirstName(), user.getFirstName());

    }

    @Test
    public void editUser() {
        when(userService.userDAO.getUserByUserName(user.getUserName())).thenReturn(null);
        userService.userDAO = mock(UserDAO.class);
        genericResponse = userService.saveUser(userSignupRequest);

        assertEquals(genericResponse.getMessage(),USER_ADD_SUCCESS);
        assertEquals(genericResponse.getStatus(), HttpStatus.CREATED.toString());

    }
}