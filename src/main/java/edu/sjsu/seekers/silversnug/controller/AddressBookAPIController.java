package edu.sjsu.seekers.silversnug.controller;

import edu.sjsu.seekers.silversnug.request.AddressBookRequest;
import edu.sjsu.seekers.silversnug.response.AddressBookResponse;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import edu.sjsu.seekers.silversnug.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressBookAPIController {

    @Autowired
    AddressBookService addressBookService;

    @PostMapping("/SilverSnug/Address/addAddress")
    @ResponseBody
    public GenericResponse addAddress(@RequestBody AddressBookRequest request) {
        return addressBookService.saveAddress(request);

        //        addressBookService.authenticate("Ashwini");
        //        return "Hello from Silver Snug!";
    }

    @GetMapping("/SilverSnug/Address/getAddress")
    public AddressBookResponse getAddress(String userName) {
        return addressBookService.getAddressByUserName(userName);
    }

}

