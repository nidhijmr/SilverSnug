package edu.sjsu.seekers.silversnug.response;

public class FallDetectionEmergencyContactResponse extends GenericResponse {

    private static final long serialVersionUID = 1L;
    private String emergencyContactNumber;
    private String userId;


    public FallDetectionEmergencyContactResponse ()
    {

    }

    public FallDetectionEmergencyContactResponse(String userId, String emergencyContactNumber)
    {
        this.emergencyContactNumber = emergencyContactNumber;
        this.userId = userId;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "FallDetectionEmergencyContactResponse{" +
                "emergencyContactNumber='" + emergencyContactNumber + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
