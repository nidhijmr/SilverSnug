package edu.sjsu.seekers.silversnug.service;

import edu.sjsu.seekers.silversnug.dao.AddressBookDao;
import edu.sjsu.seekers.silversnug.model.AddressBook;
import edu.sjsu.seekers.silversnug.request.AddressBookRequest;
import edu.sjsu.seekers.silversnug.response.AddressBookResponse;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressBookServiceTest {

    AddressBookService service;
    private static final String USER_ID="680cdb82-c044-4dd1-ae84-1a15e54ab502";
    private String TEST_ADD  = "TestAddressName";
    private String TEST_LAT = "0.00";
    private String TEST_LON = "0.00";
    private String TEST_ADDRESS = "TestAddress";
//    AddressBook add;

    @Before
    public void setup()
    {
        service = new AddressBookService();
        //service.setAddressBookDao(mock(AddressBookDao.class));
        service.addressBookDao = mock(AddressBookDao.class);
        String addressUUID = UUID.randomUUID().toString();
//        add = new AddressBook(USER_ID,addressUUID,TEST_ADD,TEST_LAT,TEST_LON);
    }

    @Test
    public void saveAddress()
    {
        AddressBookRequest request = mock(AddressBookRequest.class);

        GenericResponse result = service.saveAddress(request);

        if(result!=null){
            assertEquals(result.getMessage().toUpperCase(),"SUCCESS");
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
        addList.add(new AddressBook(USER_ID,addressUUID,TEST_ADD,TEST_LAT,TEST_LON,TEST_ADDRESS));
        AddressBookResponse response = new AddressBookResponse(addList);
        when(service.addressBookDao.getAddressByAddressName(USER_ID,TEST_ADD)).thenReturn(null);
        AddressBookResponse result = service.get1AddressByUserId(USER_ID,TEST_ADD);

        if(result!=null){
            assertEquals(result.getMessage(),"No address found for this User");
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
        when(service.addressBookDao.getAddressIdByAddressName(USER_ID,TEST_ADD)).thenReturn(null);
//        when(service.removeAddress(USER_ID,TEST_ADD)).thenReturn(response);

        GenericResponse result = service.removeAddress(USER_ID,TEST_ADD);


        if(result!=null){
            assertEquals(result.getMessage(),"No address found for this User");
//            assertEquals(result.getStatus(),HttpStatus.OK.toString());
        }
        else {

            assertFalse("Unable to remoev address",true);
        }
    }
}
