package edu.sjsu.seekers.silversnug.dao;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.util.CollectionUtils;
import edu.sjsu.seekers.silversnug.model.User;
import edu.sjsu.seekers.silversnug.model.UserLocation;
import edu.sjsu.seekers.silversnug.request.LoginRequest;
import edu.sjsu.seekers.silversnug.response.UserLocationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserLocationDAO {

    @Autowired
    DynamoDbClient dynamodbClient;
    private final String SUCCESS = "SUCCESS";

    public DynamoDBMapper dynamoDBMapper;
    List<UserLocation> userlatLong;
    String[] todaydateArray;
    String userName;

    public UserLocationResponse getUserLocations(String userName) {


        AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);


        Map<String, AttributeValue> userVal = new HashMap<>();
        userVal.put(":Patient_UserName", new AttributeValue().withS(userName));
        //userValues.put(":Datetym", new AttributeValue().withS("Mon Apr 09 20:03:16 PDT 2018"));
        //userVal.put(":Datetym", new AttributeValue().withS(todaydateArray[0]+ " "+ todaydateArray[1] + " " + todaydateArray[2]));
         userVal.put(":Datetym", new AttributeValue().withS("Fri Mar 29 "));

        Map<String, String> userVal2 = new HashMap<>();
        userVal2.put("#Dt", "DateTime");

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("Patient_UserName = :Patient_UserName and contains(#Dt, :Datetym)").withExpressionAttributeValues(userVal).withExpressionAttributeNames(userVal2);

        try {
            userlatLong = mapper.scan(UserLocation.class, scanExpression);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        if (userlatLong != null && !userlatLong.isEmpty()) {
            System.out.println("****Data Fetched****" + userlatLong.get(0).toString() + userlatLong.get(1).toString());
            UserLocationResponse userLocationResponse = new UserLocationResponse();
            userLocationResponse.setMessage(SUCCESS);
            userLocationResponse.setStatus(HttpStatus.OK.toString());
            userLocationResponse.setUserLocations(userlatLong);
            return userLocationResponse;
        }
        return null;
    }
}
