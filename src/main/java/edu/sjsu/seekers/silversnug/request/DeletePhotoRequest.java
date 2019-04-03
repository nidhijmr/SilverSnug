package edu.sjsu.seekers.silversnug.request;

import java.io.Serializable;

public class DeletePhotoRequest implements Serializable{

    private static final long serialVersionUID = 1L;
    private String photoId;
    private String userId;

    public DeletePhotoRequest()
    {

    }

    public DeletePhotoRequest(String userId, String photoId)
    {
        this.userId = userId;
        this.photoId =  photoId;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
                "userId='" + userId + '\'' +
                ", photoId='" + photoId + '\'' +
                '}';
    }
}
