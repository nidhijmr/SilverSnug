package edu.sjsu.seekers.silversnug.service;

import edu.sjsu.seekers.silversnug.dao.UserLocationDAO;
import edu.sjsu.seekers.silversnug.response.UserLocationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserLocationService {
    @Autowired
    UserLocationDAO userLocationDAO;

    public UserLocationResponse getUserLocations(String userName) {

        UserLocationResponse response = new UserLocationResponse();
        UserLocationResponse userLocationResponse = userLocationDAO.getUserLocations(userName);
        if (null != userLocationResponse) {
            response = userLocationResponse;
        } else {
            response.setMessage("No address found for this User");
            response.setMessage(HttpStatus.NO_CONTENT.toString());
        }

        return response;
    }
}
