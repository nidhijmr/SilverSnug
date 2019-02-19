package edu.sjsu.seekers.silversnug.dao;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.util.CollectionUtils;
import edu.sjsu.seekers.silversnug.model.AddressBook;
import edu.sjsu.seekers.silversnug.response.AddressBookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AddressBookDao {

    private final String SUCCESS = "SUCCESS";

    @Autowired
    DynamoDbClient dynamodbClient;
    public void authenticate(String username) {
        System.out.println("In DAO: " + username);
    }

    public void save(AddressBook addressBook) {
        AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);
        mapper.save(addressBook);
    }

    public AddressBookResponse getAddressByUserId(String userId) {
        AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);

        Map<String, AttributeValue> values = new HashMap<>();
        values.put(":userId", new AttributeValue().withS(userId));
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("userId = :userId").withExpressionAttributeValues(values);

        List<AddressBook> addressbook = mapper.scan(AddressBook.class, scanExpression);
        if (!CollectionUtils.isNullOrEmpty(addressbook)) {
            AddressBookResponse addressBookResponse = new AddressBookResponse();
            addressBookResponse.setAddressBooks(addressbook);
            addressBookResponse.setStatus(HttpStatus.OK.toString());
            addressBookResponse.setMessage(SUCCESS);
            return addressBookResponse;
        }
        return null;
    }

    public String getAddressIdByAddressName(String userId,String addressName) {
        AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);

        Map<String, AttributeValue> values = new HashMap<>();
        values.put(":userId", new AttributeValue().withS(userId));
        values.put(":addressName", new AttributeValue().withS(addressName));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("userId = :userId and addressName = :addressName")
                .withExpressionAttributeValues(values);

        List<AddressBook> addressId = mapper.scan(AddressBook.class, scanExpression);
        if (!CollectionUtils.isNullOrEmpty(addressId)) {
            System.out.println(addressId.get(0).getAddressId());
            return addressId.get(0).getAddressId();
        }
        return null;
    }

    public void removeAddress(String addressID) {
        AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);
        AddressBook obj = mapper.load(AddressBook.class, addressID);
        mapper.delete(obj);
    }

}
