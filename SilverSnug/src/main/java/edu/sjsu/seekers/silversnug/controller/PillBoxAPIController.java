package edu.sjsu.seekers.silversnug.controller;

import edu.sjsu.seekers.silversnug.request.AddressBookRequest;
import edu.sjsu.seekers.silversnug.request.DeletePillRequest;
import edu.sjsu.seekers.silversnug.request.EditPillRequest;
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
        public PillBoxResponse getPill(String userId) {
            return pillBoxService.getPillByUserId(userId);
        }

        @PostMapping("/SilverSnug/PillBox/deletePill")
        @ResponseBody
        public GenericResponse deletepill(String userId,String medicineName)
        {
            return pillBoxService.deletePill(userId,medicineName);
        }

    @PostMapping("/SilverSnug/PillBox/editPill")
    @ResponseBody
    public GenericResponse editPill(@RequestBody PillBoxRequest request)
    {
        return pillBoxService.editPill(request);
    }
    }

