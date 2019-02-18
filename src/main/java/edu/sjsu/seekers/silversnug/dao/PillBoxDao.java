package edu.sjsu.seekers.silversnug.dao;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.util.CollectionUtils;
import edu.sjsu.seekers.silversnug.model.AddressBook;
import edu.sjsu.seekers.silversnug.model.PillBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PillBoxDao {

    @Autowired
    DynamoDbClient dynamodbClient;
    public void authenticate(String username) {
        System.out.println("In DAO: " + username);}

        public void save(PillBox pillBox) {
            AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
            DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);
            mapper.save(pillBox);
        }

        public PillBox getPillByUserName(String userName) {
            AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
            DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);

            Map<String, AttributeValue> values = new HashMap<>();
            values.put(":userName", new AttributeValue().withS(userName));
            DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                    .withFilterExpression("userName = :userName").withExpressionAttributeValues(values);

            List<PillBox> pillbox = mapper.scan(PillBox.class, scanExpression);
            if (!CollectionUtils.isNullOrEmpty(pillbox)) {
                return pillbox.get(0);
            }
            return null;
        }
    }

