package edu.sjsu.seekers.silversnug.controller;

import edu.sjsu.seekers.silversnug.response.GenericResponse;
import edu.sjsu.seekers.silversnug.response.UserLocationResponse;
import edu.sjsu.seekers.silversnug.service.PanicDetectionService;
import edu.sjsu.seekers.silversnug.service.UserLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PanicDetectionController {

    @Autowired
    PanicDetectionService panicDetectionService;


    @GetMapping("/SilverSnug/Panic/SendPanicNotification")
    public GenericResponse getUserLocations(@RequestParam(value="userName") String userName ) {
        return panicDetectionService.sendPanicNotification(userName);
    }
}
