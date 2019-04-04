package edu.sjsu.seekers.silversnug.controller;


import edu.sjsu.seekers.silversnug.response.FallDetectionEmergencyContactResponse;
import edu.sjsu.seekers.silversnug.service.FallDetectionEmergencyContactNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallDetectionAPIController {

    @Autowired
    FallDetectionEmergencyContactNumber fallDetectionEmergencyContactNumber;

    @GetMapping("/SilverSnug/FallDetection/getEmergencyContact")
    public FallDetectionEmergencyContactResponse getEmergencyContact(String userId)
    {
        System.out.println(userId);
        return fallDetectionEmergencyContactNumber.getEmergencyContactNumber(userId);

    }

}
