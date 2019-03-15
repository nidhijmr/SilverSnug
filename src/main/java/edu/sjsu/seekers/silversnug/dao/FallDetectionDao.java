package edu.sjsu.seekers.silversnug.dao;


import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.util.CollectionUtils;
import edu.sjsu.seekers.silversnug.model.PhotoGallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import edu.sjsu.seekers.silversnug.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FallDetectionDao {

    @Autowired
    DynamoDbClient dynamodbClient;


    public User getEmergencyContactNumber(String userName)
    {
        AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);

        Map<String, AttributeValue> values = new HashMap<>();
        values.put(":userName", new AttributeValue().withS(userName));
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("userName = :userName").withExpressionAttributeValues(values);

        List<User> user = mapper.scan(User.class, scanExpression);
        System.out.println("User " + user);
        if (!CollectionUtils.isNullOrEmpty(user)) {
            System.out.println("Returned value= " +user.get(0).getEmergencyContactNumber());
            return user.get(0);
        }

        return null;
    }

}



