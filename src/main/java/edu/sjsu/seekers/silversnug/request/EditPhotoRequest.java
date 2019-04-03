package edu.sjsu.seekers.silversnug.request;

import java.io.Serializable;

public class EditPhotoRequest implements Serializable{

    private static final long serialVersionUID = 1L;
    private String userId;
    private String photo;
    private String photoName;
    private String contactNumber;

    public EditPhotoRequest()
    {

    }

    public EditPhotoRequest(String photo, String photoName, String contactNumber)
    {
        this.photo = photo;
        this.photoName= photoName;
        this.contactNumber = contactNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "PhotoGalleryRequest{" +
                "userId='" + userId + '\'' +
                ", photo='" + photo + '\'' +
                ", photoName='" + photoName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }

}
