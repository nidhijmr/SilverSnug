package edu.sjsu.seekers.silversnug.service;


import edu.sjsu.seekers.silversnug.dao.FallDetectionDao;
import edu.sjsu.seekers.silversnug.dao.UserDAO;
import edu.sjsu.seekers.silversnug.model.User;
import edu.sjsu.seekers.silversnug.response.FallDetectionEmergencyContactResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FallDetectionEmergencyContactNumber {

    private final String SUCCESS = "SUCCESS";

    @Autowired
    UserDAO userDAO;

    @Autowired
    FallDetectionDao fallDetectionDao;


    public FallDetectionEmergencyContactResponse getEmergencyContactNumber(String userName)
    {
        FallDetectionEmergencyContactResponse response = new FallDetectionEmergencyContactResponse();

        String EmergencyContactNumber = "";
        System.out.println("Inside Emergerncy Contact number service");
        User user = fallDetectionDao.getEmergencyContactNumber(userName);

        if(user!=null)
        {
            response.setUserName(userName);
            response.setEmergencyContactNumber(user.getEmergencyContactNumber());

        }

      /*  if(null!=EmergencyContactNumber)
        {
            response.setUserName(userName);
            response.setEmergencyContactNumber(EmergencyContactNumber);

            response.setMessage(SUCCESS);
        } */

        else
        {
            response.setMessage("User doesnot exist.");
        }

        return response;


    }

}
