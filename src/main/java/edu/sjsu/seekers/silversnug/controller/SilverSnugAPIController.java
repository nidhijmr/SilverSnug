package edu.sjsu.seekers.silversnug.controller;

import edu.sjsu.seekers.silversnug.request.AddressBookRequest;
import edu.sjsu.seekers.silversnug.response.AddressBookResponse;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import edu.sjsu.seekers.silversnug.service.SilverSnugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SilverSnugAPIController {

    @Autowired
    SilverSnugService silverSnugService;

    @PostMapping("/SilverSnug/Address/addAddress")
    @ResponseBody
    public GenericResponse addAddress(@RequestBody AddressBookRequest request) {
        return silverSnugService.saveAddress(request);

        //        silverSnugService.authenticate("Ashwini");
        //        return "Hello from Silver Snug!";
    }

    @GetMapping("/SilverSnug/Address/getAddress")
    public AddressBookResponse getAddress(String userName) {
        return silverSnugService.getAddressByUserName(userName);
    }

}


