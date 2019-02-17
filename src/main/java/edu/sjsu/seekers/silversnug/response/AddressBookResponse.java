package edu.sjsu.seekers.silversnug.response;

public class AddressBookResponse extends GenericResponse {

    private static final long serialVersionUID = 2L;
    private String userName;
    private String addressId;
    private String addressName;
    private String latitude;
    private String longitude;

    public AddressBookResponse(){

    }

    public AddressBookResponse(String userName, String addressId, String addressName, String latitude, String longitude) {
        this.userName = userName;
        this.addressId = addressId;
        this.addressName = addressName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "AddressBookResponse{" +
                "userName='" + userName + '\'' +
                ", addressId='" + addressId + '\'' +
                ", addressName='" + addressName + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
