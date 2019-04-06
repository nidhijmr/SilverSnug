package edu.sjsu.seekers.silversnug.service;

import edu.sjsu.seekers.silversnug.dao.UserDAO;
import edu.sjsu.seekers.silversnug.dao.UserLocationDAO;
import edu.sjsu.seekers.silversnug.model.UserLocation;
import edu.sjsu.seekers.silversnug.response.UserLocationResponse;
import edu.sjsu.seekers.silversnug.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static edu.sjsu.seekers.silversnug.util.Constants.SUCCESS_GET;

@Service
public class UserLocationService {
    @Autowired
    UserLocationDAO userLocationDAO;

    public List<UserLocationResponse> getUserLocations(String userName) {

        List<UserLocationResponse> responseList = new ArrayList<>();
        List<UserLocation> userLocations = userLocationDAO.getUserLocations(userName);


        for(UserLocation userLocation : userLocations){
            System.out.println("userLocation" + userLocation);
            UserLocationResponse response = new UserLocationResponse(HttpStatus.OK.toString(), SUCCESS_GET, userLocation.getID(), userLocation.getAnomalyScore(), userLocation.getDateTime(),
                    userLocation.getLatitude(), userLocation.getLongitude(), userLocation.getUsername());
            responseList.add(response);
        }
        return responseList;
    }
}
