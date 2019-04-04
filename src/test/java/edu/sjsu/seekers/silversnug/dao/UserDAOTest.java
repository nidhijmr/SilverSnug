package edu.sjsu.seekers.silversnug.dao;

import edu.sjsu.seekers.silversnug.model.User;
import edu.sjsu.seekers.silversnug.request.LoginRequest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.Assert.*;

public class UserDAOTest {

    public static final String USER_NAME = "nidhi";
    public static final String PASSWORD = "nidhi";


    UserDAO userDAO;

    LoginRequest loginRequest;

    User user, newUser;

    @Before
    public void setup()
    {
        userDAO = new UserDAO();
        userDAO.dynamodbClient = new DynamoDbClient();
        loginRequest = new LoginRequest(USER_NAME, PASSWORD);

    }

    @Test
    public void authenticate() {
        user = userDAO.authenticate(loginRequest);

        assertEquals(user.getUserName(), USER_NAME);
        assertEquals(user.getPassword(), PASSWORD);
    }

    @Test
    public void saveUser() {
        String uuid = UUID.randomUUID().toString();
        newUser = new User("testUser", uuid, "nidhi.jmr1@gmail.com", "6693007100", "testUser", "testUser", "testUser",  "6693007100", "profileImage", "patient1");
        userDAO.saveUser(newUser);

        User userExisting  = userDAO.getUserByUserName(newUser.getUserName());

        if(userExisting != null) {
            System.out.println("user created successfully: " + userExisting.getUserId());
            userDAO.deleteUser(userExisting);
            assertEquals(userExisting.getUserName(), newUser.getUserName());
        }
        else{
            fail("test case failed");
        }



    }

    @Test
    public void getUserByUserName() {
        User userExisting  = userDAO.getUserByUserName(USER_NAME);

        if(userExisting != null) {
            System.out.println("user created successfully: " + userExisting.getUserId());
            assertEquals(userExisting.getUserName(), USER_NAME);
        }
        else{
            fail("test case failed");
        }
    }
}