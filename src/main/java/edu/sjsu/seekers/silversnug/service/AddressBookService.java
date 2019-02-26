package edu.sjsu.seekers.silversnug.service;
import edu.sjsu.seekers.silversnug.dao.AddressBookDao;
import edu.sjsu.seekers.silversnug.model.AddressBook;
import edu.sjsu.seekers.silversnug.request.AddressBookRequest;
import edu.sjsu.seekers.silversnug.response.AddressBookResponse;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddressBookService {

    private final String SUCCESS = "SUCCESS";

    @Autowired
    AddressBookDao addressBookDao;

    public void authenticate(String username) {
        System.out.println("In service: " + username);
        addressBookDao.authenticate(username);
    }

    public GenericResponse saveAddress(AddressBookRequest request) {

        String addressUUID = UUID.randomUUID().toString();
        AddressBook addressBook = new AddressBook();
        addressBook.setUserId(request.getUserId());
        addressBook.setAddressId(addressUUID);
        addressBook.setAddressName(request.getAddressName());
        addressBook.setLatitude(request.getLatitude());
        addressBook.setLongitude(request.getLongitude());
        addressBookDao.save(addressBook);

        GenericResponse response = new GenericResponse();
        response.setMessage(SUCCESS);
        response.setStatus(HttpStatus.OK.toString());

        return response;
    }

    public AddressBookResponse getAddressByUserId(String userId) {
        AddressBookResponse response = new AddressBookResponse();

        AddressBookResponse addressBookResponse = addressBookDao.getAddressByUserId(userId);
        if (null != addressBookResponse) {
            response = addressBookResponse;
        } else {
            response.setMessage("No address found for this User");
        }

        return response;
    }

    public GenericResponse removeAddress(String userId,String addressName) {

        GenericResponse response = new GenericResponse();
        String addressID = addressBookDao.getAddressIdByAddressName(userId,addressName);
        if(addressID!=null) {
            addressBookDao.removeAddress(addressID);
            response.setMessage(SUCCESS);
            response.setStatus(HttpStatus.OK.toString());
        }

        else {
            response.setMessage("No address found for this User");
        }

        return response;
    }

}
