package edu.sjsu.seekers.silversnug.request;

import java.io.Serializable;

public class DeletePhotoRequest implements Serializable{

    private static final long serialVersionUID = 1L;
    private String photoName;
    private String userId;

    public DeletePhotoRequest()
    {

    }

    public DeletePhotoRequest(String userId, String photoName)
    {
        this.userId = userId;
        this.photoName =  photoName;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    @Override
    public String toString() {
        return "PhotoGalleryRequest{" +
                "userId='" + userId + '\'' +
                ", photoName='" + photoName + '\'' +
                '}';
    }
}
