package edu.sjsu.seekers.silversnug.controller;

import edu.sjsu.seekers.silversnug.dao.AddressBookDao;
import edu.sjsu.seekers.silversnug.dao.DynamoDbClient;
import edu.sjsu.seekers.silversnug.model.AddressBook;
import edu.sjsu.seekers.silversnug.request.AddressBookRequest;
import edu.sjsu.seekers.silversnug.response.AddressBookResponse;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import edu.sjsu.seekers.silversnug.service.AddressBookService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.util.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressBookAPIControllerTest {
    @MockBean
    AddressBookService addService;
    AddressBookAPIController controller;
    private static final String USER_ID="680cdb82-c044-4dd1-ae84-1a15e54ab502";
    private String TEST_ADD  = "TestAddressName";
    private String TEST_LAT = "0.00";
    private String TEST_LON = "0.00";

    @Before
    public void setup()
    {
        controller = new AddressBookAPIController();
        controller.addressBookService = mock(AddressBookService.class);

    }

    @Test
    public void saveAddress()
    {

        GenericResponse response = new GenericResponse();
        response.setMessage("SUCCESS");
        response.setStatus(HttpStatus.OK.toString());

        AddressBookRequest request = mock(AddressBookRequest.class);

        when(controller.addAddress(request)).thenReturn((AddressBookResponse) response);


        GenericResponse result = controller.addAddress(request);

        if(result!=null){
            assertEquals(result.getMessage(),"SUCCESS");
            assertEquals(result.getStatus(),HttpStatus.OK.toString());
        }
        else {
            assertFalse("Unable to find the addressbook Object ",true);
        }

    }

    @Test
    public void getAddress()
    {
        List<AddressBook> addList = new ArrayList<AddressBook>();
        String addressUUID = UUID.randomUUID().toString();
        addList.add(new AddressBook(USER_ID,addressUUID,TEST_ADD,TEST_LAT,TEST_LON));
        AddressBookResponse response = new AddressBookResponse(addList);

        when(controller.getAddressByID(USER_ID,TEST_ADD)).thenReturn(response);

        AddressBookResponse result = controller.getAddressByID(USER_ID,TEST_ADD);
        if(result!=null){
            AddressBook add = result.getAddressBooks().get(0);
            assertEquals(add.getAddressId(),addressUUID);
            assertEquals(add.getLatitude(),TEST_LAT);
            assertEquals(add.getLongitude(),TEST_LON);
        }
        else {
            assertFalse("Unable to find the addressbook Object ",true);
        }
    }

    @Test
    public void removeAddress()
    {
        GenericResponse response = new GenericResponse();
        response.setMessage("SUCCESS");
        response.setStatus(HttpStatus.OK.toString());

        AddressBookRequest request = mock(AddressBookRequest.class);

        when(controller.removeAddress(USER_ID,TEST_ADD)).thenReturn(response);


        GenericResponse result = controller.removeAddress(USER_ID,TEST_ADD);


        if(result!=null){
            assertEquals(result.getMessage(),"SUCCESS");
            assertEquals(result.getStatus(),HttpStatus.OK.toString());
        }
        else {

            assertFalse("Unable to remoev address",true);
        }


    }
}
