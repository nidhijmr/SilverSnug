package edu.sjsu.seekers.silversnug.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "photogallery")
public class PhotoGallery {
    private String photoId;
    private String userName;
    private String photo;
    private String photoName;
    private String contactNumber;

    public PhotoGallery()
    {

    }

    public PhotoGallery(String photoId, String userName, String photo, String photoName, String contactNumber)
    {
        this.photoId = photoId;
        this.userName = userName;
        this.photo = photo;
        this.photoName= photoName;
        this.contactNumber = contactNumber;

    }

    @DynamoDBHashKey(attributeName = "photoId")
    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }


    @DynamoDBAttribute(attributeName = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

}
