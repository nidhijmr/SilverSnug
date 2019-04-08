package edu.sjsu.seekers.silversnug.service;
import edu.sjsu.seekers.silversnug.dao.AddressBookDao;
import edu.sjsu.seekers.silversnug.model.AddressBook;
import edu.sjsu.seekers.silversnug.request.AddressBookRequest;
import edu.sjsu.seekers.silversnug.response.AddressBookResponse;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
public class AddressBookService {

    private final String SUCCESS = "SUCCESS";

    @Autowired
    AddressBookDao addressBookDao;

    public void authenticate(String username) {
        System.out.println("In service: " + username);
        getAddressBookDao().authenticate(username);
    }

    public GenericResponse saveAddress(AddressBookRequest request) {

        String addressUUID = UUID.randomUUID().toString();
        AddressBook addressBook = new AddressBook();
        addressBook.setUserId(request.getUserId());
        addressBook.setAddressId(addressUUID);
        addressBook.setAddressName(request.getAddressName());
        addressBook.setLatitude(request.getLatitude());
        addressBook.setLongitude(request.getLongitude());
        getAddressBookDao().save(addressBook);

        GenericResponse response = new GenericResponse();
        response.setMessage(SUCCESS);
        response.setStatus(HttpStatus.OK.toString());

        return response;
    }

    public AddressBookResponse getAddressByUserId(String userId) {
        AddressBookResponse response = new AddressBookResponse();

        AddressBookResponse addressBookResponse = getAddressBookDao().getAddressByUserId(userId);
        if (null != addressBookResponse) {
            response = addressBookResponse;
        } else {
            response.setMessage("No address found for this User");
        }

        return response;
    }

    public AddressBookResponse get1AddressByUserId(String userId,String addressName) {
        AddressBookResponse response = new AddressBookResponse();

        AddressBook addressBook = getAddressBookDao().getAddressByAddressName(userId,addressName);
        if (null != addressBook) {
            response.setAddressBooks(Collections.singletonList(addressBook));
        } else {
            response.setMessage("No address found for this User");
        }

        return response;
    }

    public GenericResponse removeAddress(String userId,String addressName) {

        GenericResponse response = new GenericResponse();
        String addressID = getAddressBookDao().getAddressIdByAddressName(userId,addressName);
        if(addressID!=null) {
            getAddressBookDao().removeAddress(addressID);
            response.setMessage(SUCCESS);
            response.setStatus(HttpStatus.OK.toString());
        }

        else {
            response.setMessage("No address found for this User");
        }

        return response;
    }

    public AddressBookDao getAddressBookDao() {
        return addressBookDao;
    }

    public void setAddressBookDao(AddressBookDao addressBookDao) {
        this.addressBookDao = addressBookDao;
    }
}
