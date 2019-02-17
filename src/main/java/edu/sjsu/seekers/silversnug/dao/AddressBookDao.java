package edu.sjsu.seekers.silversnug.dao;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.util.CollectionUtils;
import edu.sjsu.seekers.silversnug.model.AddressBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AddressBookDao {

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

    public AddressBook getAddressByUserName(String userName) {
        AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);

        Map<String, AttributeValue> values = new HashMap<>();
        values.put(":userName", new AttributeValue().withS(userName));
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("userName = :userName").withExpressionAttributeValues(values);

        List<AddressBook> addressbook = mapper.scan(AddressBook.class, scanExpression);
        if (!CollectionUtils.isNullOrEmpty(addressbook)) {
            return addressbook.get(0);
        }
        return null;
    }

}
