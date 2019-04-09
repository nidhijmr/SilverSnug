package edu.sjsu.seekers.silversnug.dao;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.util.CollectionUtils;
import edu.sjsu.seekers.silversnug.model.AddressBook;
import edu.sjsu.seekers.silversnug.model.PhotoGallery;
import edu.sjsu.seekers.silversnug.request.EditPhotoRequest;
import edu.sjsu.seekers.silversnug.response.PhotoGalleryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PhotoGalleryDao {

    @Autowired
    DynamoDbClient dynamodbClient;

    private final String SUCCESS = "SUCCESS";

    public void save(PhotoGallery photoGallery)
    {
        AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);
        mapper.save(photoGallery);
    }

    public PhotoGalleryResponse getPhotoGalleryByUserId(String userId)
    {
        AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);

        Map<String, AttributeValue> values = new HashMap<>();
        values.put(":userId", new AttributeValue().withS(userId));
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("userId = :userId").withExpressionAttributeValues(values);

        List<PhotoGallery> photogallery = mapper.scan(PhotoGallery.class, scanExpression);
        if (!CollectionUtils.isNullOrEmpty(photogallery)) {
            PhotoGalleryResponse photoGalleryResponse = new PhotoGalleryResponse();
            photoGalleryResponse.setPhotos(photogallery);
            photoGalleryResponse.setStatus(HttpStatus.OK.toString());
            photoGalleryResponse.setMessage(SUCCESS);
            return photoGalleryResponse;
        }
        return null;
    }

    public void deletePhoto( String userId, String photoName)
    {
        AmazonDynamoDB dynamoDB = dynamodbClient.getDynamoDB();
        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);

        Map<String, AttributeValue> values = new HashMap<>();
        values.put(":userId", new AttributeValue().withS(userId));
        values.put(":photoName", new AttributeValue().withS(photoName));
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("userId = :userId and photoName = :photoName").withExpressionAttributeValues(values);

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
        values.put(":userId", new AttributeValue().withS(request.getUserId()));
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("userId = :userId").withExpressionAttributeValues(values);

        List<PhotoGallery> photogallery = mapper.scan(PhotoGallery.class, scanExpression);
        if (!CollectionUtils.isNullOrEmpty(photogallery)) {
            if(request.getPhoto()!= null)
            photogallery.get(0).setPhoto(request.getPhoto());
            if(request.getPhotoName()!= null)
            photogallery.get(0).setPhotoName(request.getPhotoName());
            if(request.getContactNumber()!= null)
            photogallery.get(0).setContactNumber(request.getContactNumber());
            if(request.getRelationship()!=null)
                photogallery.get(0).setRelationship(request.getRelationship());
            mapper.save(photogallery.get(0));
        }
    }
}
