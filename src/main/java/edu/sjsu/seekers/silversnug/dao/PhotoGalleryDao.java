package edu.sjsu.seekers.silversnug.dao;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.util.CollectionUtils;
import edu.sjsu.seekers.silversnug.model.AddressBook;
import edu.sjsu.seekers.silversnug.model.PhotoGallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PhotoGalleryDao {

    @Autowired
    DynamoDbClient dynamodbClient;

    public void save(PhotoGallery photoGallery)
    {
        AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);
        mapper.save(photoGallery);
    }

    public PhotoGallery getPhotoGalleryByUserName( String userName)
    {
        AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);

        Map<String, AttributeValue> values = new HashMap<>();
        values.put(":userName", new AttributeValue().withS(userName));
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("userName = :userName").withExpressionAttributeValues(values);

        List<PhotoGallery> photogallery = mapper.scan(PhotoGallery.class, scanExpression);
        if (!CollectionUtils.isNullOrEmpty(photogallery)) {
            return photogallery.get(0);
        }
        return null;
    }

}
