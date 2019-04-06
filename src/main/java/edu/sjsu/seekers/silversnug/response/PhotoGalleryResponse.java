package edu.sjsu.seekers.silversnug.response;

public class PhotoGalleryResponse extends GenericResponse {

        private static final long serialVersionUID = 1L;
        private String photoId;
        private String userId;
        private String photo;
        private String photoName;
        private String contactNumber;

        public PhotoGalleryResponse()
        {

        }

        public PhotoGalleryResponse(String photoId, String userId, String photo, String photoName, String contactNumber)
        {
            this.photoId = photoId;
            this.userId = userId;
            this.photo = photo;
            this.photoName= photoName;
            this.contactNumber = contactNumber;
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

        @Override
        public String toString() {
            return "PhotoGalleryResponse{" +
                    "photoId='" + photoId + '\'' +
                    ", userId='" + userId + '\'' +
                    ", photo='" + photo + '\'' +
                    ", photoName='" + photoName + '\'' +
                    ", contactNumber='" + contactNumber + '\'' +
                    '}';
        }
}
