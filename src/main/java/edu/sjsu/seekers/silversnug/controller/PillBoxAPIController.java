package edu.sjsu.seekers.silversnug.controller;

import edu.sjsu.seekers.silversnug.request.AddressBookRequest;
import edu.sjsu.seekers.silversnug.request.PillBoxRequest;
import edu.sjsu.seekers.silversnug.response.AddressBookResponse;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import edu.sjsu.seekers.silversnug.response.PillBoxResponse;
import edu.sjsu.seekers.silversnug.service.AddressBookService;
import edu.sjsu.seekers.silversnug.service.PillBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PillBoxAPIController {

        @Autowired
        PillBoxService pillBoxService;

        @PostMapping("/SilverSnug/PillBox/addPill")
        @ResponseBody
        public GenericResponse addPill(@RequestBody PillBoxRequest request) {
            return pillBoxService.savePill(request);
        }

        @GetMapping("/SilverSnug/PillBox/getPill")
        public PillBoxResponse getPill(String userName) {
            return pillBoxService.getPillByUserName(userName);
        }

    }

