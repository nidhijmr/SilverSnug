package edu.sjsu.seekers.silversnug.service;
import edu.sjsu.seekers.silversnug.dao.UserDAO;
import edu.sjsu.seekers.silversnug.model.User;
import edu.sjsu.seekers.silversnug.request.LoginRequest;
import edu.sjsu.seekers.silversnug.request.UserSignupRequest;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import edu.sjsu.seekers.silversnug.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static edu.sjsu.seekers.silversnug.util.Constants.*;


@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public UserResponse authenticate(LoginRequest loginRequest) {
        System.out.println("Authenticating: " + loginRequest.getUserName());
        User user = userDAO.authenticate(loginRequest);
        return getUserResponse(user);
    }

    public GenericResponse saveUser(UserSignupRequest userSignupRequest) {
        GenericResponse response = new GenericResponse();
        User userOld = userDAO.getUserByUserName(userSignupRequest.getUserName());
        if (null == userOld) {

            String uuid = UUID.randomUUID().toString();

            User user = new User(userSignupRequest.getUserName(), uuid, userSignupRequest.getEmailId(),
                    userSignupRequest.getEmergencyContactNumber(), userSignupRequest.getFirstName(), userSignupRequest.getLastName(), userSignupRequest.getPassword(),
                    userSignupRequest.getPhoneNumber(), userSignupRequest.getProfileImage(), userSignupRequest.getRole());
            userDAO.saveUser(user);


            response.setMessage(USER_ADD_SUCCESS);
            response.setStatus(HttpStatus.CREATED.toString());
        }
        else{
            response.setMessage(USERNAME_ALREADY_EXISTS);
            response.setStatus(HttpStatus.EXPECTATION_FAILED.toString());
        }
        return response;
    }

    public UserResponse getUserByUserName(String userName) {
        User user = userDAO.getUserByUserName(userName);
        return getUserResponse(user);
    }

    private UserResponse getUserResponse(User user) {
        UserResponse response = new UserResponse();
        if (null != user) {
            response = new UserResponse(HttpStatus.OK.toString(), SUCCESS_GET, user.getUserName(), user.getUserId(), user.getEmailId(),
                    user.getEmergencyContactNumber(), user.getFirstName(), user.getLastName(), user.getPassword(),
                    user.getPhoneNumber(), user.getProfileImage(), user.getRole());
        } else {
            response.setMessage(UNSUCCESSFUL_GET_USER);
        }

        return response;
    }

    public GenericResponse editUser(UserSignupRequest editUserRequest) {
        GenericResponse response = new GenericResponse();
        User userOld = userDAO.getUserByUserName(editUserRequest.getUserName());
        if (null == userOld) {
            response.setMessage(USERNAME_DOES_NOT_EXISTS);
            response.setStatus(HttpStatus.EXPECTATION_FAILED.toString());
        }
        else{
            System.out.println("Updating user: " + editUserRequest.getUserName());
            userOld.setEmailId(editUserRequest.getEmailId());
            userOld.setEmergencyContactNumber(editUserRequest.getEmergencyContactNumber());
            userOld.setFirstName(editUserRequest.getFirstName());
            userOld.setLastName(editUserRequest.getLastName());
            userOld.setPassword(editUserRequest.getPassword());
            userOld.setProfileImage(editUserRequest.getProfileImage());
            userOld.setRole(editUserRequest.getRole());
            userOld.setPhoneNumber(editUserRequest.getPhoneNumber());
            userDAO.saveUser(userOld);
            response.setMessage(SUCCESS_GET);
            response.setStatus(HttpStatus.OK.toString());

        }
        return response;
    }
}
