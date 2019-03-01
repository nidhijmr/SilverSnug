package edu.sjsu.seekers.silversnug.response;

public class PhotoGalleryResponse extends GenericResponse {

        private static final long serialVersionUID = 1L;
        private String photoId;
        private String userName;
        private String photo;
        private String photoName;
        private String contactNumber;

        public PhotoGalleryResponse()
        {

        }

        public PhotoGalleryResponse(String photoId, String userName, String photo, String photoName, String contactNumber)
        {
            this.photoId = photoId;
            this.userName = userName;
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

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
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
                    ", userName='" + userName + '\'' +
                    ", photo='" + photo + '\'' +
                    ", photoName='" + photoName + '\'' +
                    ", contactNumber='" + contactNumber + '\'' +
                    '}';
        }
}
