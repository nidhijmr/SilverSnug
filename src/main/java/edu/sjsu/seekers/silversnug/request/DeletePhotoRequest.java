package edu.sjsu.seekers.silversnug.request;

import java.io.Serializable;

public class DeletePhotoRequest implements Serializable{

    private static final long serialVersionUID = 1L;
    private String photoId;
    private String userName;

    public DeletePhotoRequest()
    {

    }

    public DeletePhotoRequest(String userName, String photoId)
    {
        this.userName = userName;
        this.photoId =  photoId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    @Override
    public String toString() {
        return "PhotoGalleryRequest{" +
                "userName='" + userName + '\'' +
                ", photoId='" + photoId + '\'' +
                '}';
    }
}
