package edu.sjsu.seekers.silversnug.response;

import edu.sjsu.seekers.silversnug.model.PhotoGallery;

import java.util.List;

public class PhotoGalleryResponse extends GenericResponse {

        private static final long serialVersionUID = 1L;

    private List<PhotoGallery> photos;

    public PhotoGalleryResponse(){

    }

    public PhotoGalleryResponse(List<PhotoGallery> photos) {
        super();
        this.photos = photos;
    }

    public List<PhotoGallery> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoGallery> photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "PhotoGalleryResponse{" +
                "photos=" + photos +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }


      //  private List<PhotoGallery> photos;

      /*  private String photoId;
        private String userId;
        private String photo;
        private String photoName;
        private String contactNumber;
        private String relationship;

        public PhotoGalleryResponse()
        {

        }

       public PhotoGalleryResponse(String photoId, String userId, String photo, String photoName, String contactNumber, String relationship)
        {
            this.photoId = photoId;
            this.userId = userId;
            this.photo = photo;
            this.photoName= photoName;
            this.contactNumber = contactNumber;
            this.relationship = relationship;
        }


        public String getPhotoId() {
            return photoId;
        }

        public void setPhotoId(String photoId) {
            this.photoId = photoId;
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

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    @Override
        public String toString() {
            return "PhotoGalleryResponse{" +
                    "photoId='" + photoId + '\'' +
                    ", userId='" + userId + '\'' +
                    ", photo='" + photo + '\'' +
                    ", photoName='" + photoName + '\'' +
                    ", contactNumber='" + contactNumber + '\'' +
                    ", relationship='" + relationship + '\'' +
                    '}';
        } */


}
