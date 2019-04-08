package edu.sjsu.seekers.silversnug.response;

import edu.sjsu.seekers.silversnug.model.UserLocation;

import java.util.List;

public class UserLocationResponse extends GenericResponse  {

    private static final long serialVersionUID = 2L;

    List<UserLocation> userLocations;

    public List<UserLocation> getUserLocations() {
        return userLocations;
    }

    public void setUserLocations(List<UserLocation> userLocations) {
        this.userLocations = userLocations;
    }
    public UserLocationResponse(){}

    public UserLocationResponse(List<UserLocation> userLocations) {
        super();
        this.userLocations = userLocations;
    }

    @Override
    public String toString() {
        return "UserLocationResponse{" +
                "userLocations=" + userLocations +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
