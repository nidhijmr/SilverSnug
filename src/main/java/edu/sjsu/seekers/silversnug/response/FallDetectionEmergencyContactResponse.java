package edu.sjsu.seekers.silversnug.response;

public class FallDetectionEmergencyContactResponse extends GenericResponse {

    private static final long serialVersionUID = 1L;
    private String emergencyContactNumber;
    private String userName;


    public FallDetectionEmergencyContactResponse ()
    {

    }

    public FallDetectionEmergencyContactResponse(String username, String emergencyContactNumber)
    {
        this.emergencyContactNumber = emergencyContactNumber;
        this.userName = username;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "FallDetectionEmergencyContactResponse{" +
                "emergencyContactNumber='" + emergencyContactNumber + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
