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
    public AddressBookResponse addAddress(@RequestBody AddressBookRequest request) {
        return addressBookService.saveAddress(request);
    }

    @GetMapping("/SilverSnug/Address/getAddress")
    public AddressBookResponse getAddress(String userId) {
        return addressBookService.getAddressByUserId(userId);
    }

    @GetMapping("/SilverSnug/Address/getAddressByID")
    public AddressBookResponse getAddressByID(String userId,String addressName) {
        return addressBookService.get1AddressByUserId(userId,addressName);
    }

    @PostMapping("/SilverSnug/Address/removeAddress")
    @ResponseBody
    public GenericResponse removeAddress(String userId,String addressName) {
        return addressBookService.removeAddress(userId,addressName);
    }

}


