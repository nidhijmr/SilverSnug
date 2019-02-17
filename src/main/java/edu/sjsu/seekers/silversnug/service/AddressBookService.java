package edu.sjsu.seekers.silversnug.service;
import edu.sjsu.seekers.silversnug.dao.AddressBookDao;
import edu.sjsu.seekers.silversnug.model.AddressBook;
import edu.sjsu.seekers.silversnug.request.AddressBookRequest;
import edu.sjsu.seekers.silversnug.response.AddressBookResponse;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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

        AddressBook addressBook = new AddressBook();
        addressBook.setUserName(request.getUserName());
        addressBook.setAddressId(request.getAddressId());
        addressBook.setAddressName(request.getAddressName());
        addressBook.setLatitude(request.getLatitude());
        addressBook.setLongitude(request.getLongitude());
        addressBookDao.save(addressBook);

        GenericResponse response = new GenericResponse();
        response.setMessage(SUCCESS);
        response.setStatus(HttpStatus.OK.toString());

        return response;
    }

    public AddressBookResponse getAddressByUserName(String userName) {
        AddressBookResponse response = new AddressBookResponse();

        AddressBook addressBook = addressBookDao.getAddressByUserName(userName);
        if (null != addressBook) {
            response.setUserName(addressBook.getUserName());
            response.setAddressId(addressBook.getAddressId());
            response.setAddressName(addressBook.getAddressName());
            response.setLatitude(addressBook.getLatitude());
            response.setLongitude(addressBook.getLongitude());
            response.setMessage(SUCCESS);
        } else {
            response.setMessage("No address found for this User.");
        }

        return response;
    }
}
