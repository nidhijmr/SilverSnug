package edu.sjsu.seekers.silversnug.dao;

import edu.sjsu.seekers.silversnug.model.AddressBook;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class AddressBookDaoTest {
    private static final String USER_ID="680cdb82-c044-4dd1-ae84-1a15e54ab502";
    private String TEST_ADD  = "TestAddressName";
    private String TEST_LAT = "0.00";
    private String TEST_LON = "0.00";
    private AddressBookDao add_Dao ;

    @Before
    public void setup()
    {
        add_Dao = new AddressBookDao();
        add_Dao.dynamodbClient = new DynamoDbClient();

    }

    @Test
    public void saveAddress()
    {
        String addressUUID = UUID.randomUUID().toString();
        System.out.println(addressUUID);
        AddressBook addressBook = new AddressBook(USER_ID,addressUUID,TEST_ADD,TEST_LAT,TEST_LON);
        add_Dao.save(addressBook);

        AddressBook result = add_Dao.getAddressByAddressName(USER_ID,TEST_ADD);
        if(result!=null){
            assertEquals(result.getAddressId(),addressUUID);
            assertEquals(result.getLatitude(),TEST_LAT);
            assertEquals(result.getLongitude(),TEST_LON);
        }
        else {
            assertFalse("Unable to find the addressbook Object ",true);
        }
        add_Dao.removeAddress(addressUUID);
    }

    @Test
    public void getAddress()
    {
        String addressUUID = UUID.randomUUID().toString();
        System.out.println(addressUUID);
        AddressBook addressBook = new AddressBook(USER_ID,addressUUID,TEST_ADD,TEST_LAT,TEST_LON);
        add_Dao.save(addressBook);

        AddressBook result = add_Dao.getAddressByAddressName(USER_ID,TEST_ADD);
        if(result!=null){
            assertEquals(result.getAddressId(),addressUUID);
            assertEquals(result.getLatitude(),TEST_LAT);
            assertEquals(result.getLongitude(),TEST_LON);
        }
        else {
            assertFalse("Unable to find the addressbook Object ",true);
        }
        add_Dao.removeAddress(addressUUID);
    }

    @Test
    public void removeAddress()
    {
        String addressUUID = UUID.randomUUID().toString();
        System.out.println(addressUUID);
        AddressBook addressBook = new AddressBook(USER_ID,addressUUID,TEST_ADD,TEST_LAT,TEST_LON);
        add_Dao.save(addressBook);
        add_Dao.removeAddress(addressUUID);

        AddressBook result = add_Dao.getAddressByAddressName(USER_ID,TEST_ADD);
        if(result!=null){
            fail("In remove Address testcase,found an address.");
        }
        else {

            assertTrue("Successfuly deleted the address",true);
        }


    }
}
