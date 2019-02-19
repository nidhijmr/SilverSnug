package edu.sjsu.seekers.silversnug.dao;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.util.CollectionUtils;
import edu.sjsu.seekers.silversnug.model.AddressBook;
import edu.sjsu.seekers.silversnug.model.PhotoGallery;
import edu.sjsu.seekers.silversnug.request.EditPhotoRequest;
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

    public void deletePhoto( String userName, String photoId)
    {
        AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);

        Map<String, AttributeValue> values = new HashMap<>();
        values.put(":userName", new AttributeValue().withS(userName));
        values.put(":photoId", new AttributeValue().withS(photoId));
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("userName = :userName and photoId = :photoId").withExpressionAttributeValues(values);

        List<PhotoGallery> photogallery = mapper.scan(PhotoGallery.class, scanExpression);
        if (!CollectionUtils.isNullOrEmpty(photogallery)) {
            mapper.delete(photogallery.get(0));
        }

    }

    public void editPhoto(EditPhotoRequest request)
    {
        AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);

        Map<String, AttributeValue> values = new HashMap<>();
        values.put(":userName", new AttributeValue().withS(request.getUserName()));
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("userName = :userName").withExpressionAttributeValues(values);

        List<PhotoGallery> photogallery = mapper.scan(PhotoGallery.class, scanExpression);
        if (!CollectionUtils.isNullOrEmpty(photogallery)) {
            if(request.getPhoto()!= null)
            photogallery.get(0).setPhoto(request.getPhoto());
            if(request.getPhotoName()!= null)
            photogallery.get(0).setPhotoName(request.getPhotoName());
            if(request.getContactNumber()!= null)
            photogallery.get(0).setContactNumber(request.getContactNumber());
            mapper.save(photogallery.get(0));
        }
    }
}
