package edu.sjsu.seekers.silversnug.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "photogallery")
public class PhotoGallery {
    private String photoId;
    private String userId;
    private String photo;
    private String photoName;
    private String contactNumber;
    private String relationship;

    public PhotoGallery()
    {

    }


    public PhotoGallery(String photoId, String userId, String photo, String photoName, String contactNumber, String relationship)
    {
        this.photoId = photoId;
        this.userId = userId;
        this.photo = photo;
        this.photoName= photoName;
        this.contactNumber = contactNumber;
        this.relationship = relationship;

    }

    @DynamoDBHashKey(attributeName = "photoId")
    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }


    @DynamoDBAttribute(attributeName = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @DynamoDBAttribute(attributeName = "photo")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @DynamoDBAttribute(attributeName = "photoName")
    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    @DynamoDBAttribute(attributeName = "contactNumber")
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

}
