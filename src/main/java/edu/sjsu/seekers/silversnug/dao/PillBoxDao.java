package edu.sjsu.seekers.silversnug.dao;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.util.CollectionUtils;
import edu.sjsu.seekers.silversnug.model.PillBox;
import edu.sjsu.seekers.silversnug.request.EditPillRequest;
import edu.sjsu.seekers.silversnug.response.PillBoxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PillBoxDao {

    private final String SUCCESS = "SUCCESS";

    @Autowired
    DynamoDbClient dynamodbClient;
    public void authenticate(String username) {
        System.out.println("In DAO: " + username);}

        public void save(PillBox pillBox) {
            AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
            DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);
            mapper.save(pillBox);
        }

        public PillBoxResponse getPillByUserId(String userId) {
            AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
            DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);

            Map<String, AttributeValue> values = new HashMap<>();
            values.put(":userId", new AttributeValue().withS(userId));
            DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                    .withFilterExpression("userId = :userId").withExpressionAttributeValues(values);

            List<PillBox> pillbox = mapper.scan(PillBox.class, scanExpression);
            if (!CollectionUtils.isNullOrEmpty(pillbox)) {
                PillBoxResponse pillBoxResponse = new PillBoxResponse();
                pillBoxResponse.setPillBoxes(pillbox);
                pillBoxResponse.setStatus(HttpStatus.OK.toString());
                pillBoxResponse.setMessage(SUCCESS);
                return pillBoxResponse;
            }
            return null;
        }


    public void deletePill( String userId, String pillboxId)
    {
        AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);

        Map<String, AttributeValue> values = new HashMap<>();
        values.put(":userId", new AttributeValue().withS(userId));
        values.put(":pillBoxId", new AttributeValue().withS(pillboxId));
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("userId = :userId and pillBoxId = :pillBoxId").withExpressionAttributeValues(values);

        List<PillBox> pillbox = mapper.scan(PillBox.class, scanExpression);
        if (!CollectionUtils.isNullOrEmpty(pillbox)) {
            mapper.delete(pillbox.get(0));
        }

    }

    public void editPill(EditPillRequest request)
    {
        AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);

        Map<String, AttributeValue> values = new HashMap<>();
        values.put(":userId", new AttributeValue().withS(request.getUserId()));
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("userId = :userId").withExpressionAttributeValues(values);

        List<PillBox> pillBox = mapper.scan(PillBox.class, scanExpression);
        if (!CollectionUtils.isNullOrEmpty(pillBox)){
            if(request.getMedicineName()!= null)
                pillBox.get(0).setMedicineName(request.getMedicineName());
            if(request.getNotes()!= null)
                pillBox.get(0).setNotes(request.getNotes());
            if(request.getPotency()!= null)
                pillBox.get(0).setPotency(request.getPotency());
            if (request.getDosage()!=null)
                pillBox.get(0).setDosage(request.getDosage());
            mapper.save(pillBox.get(0));
        }
    }
    }

