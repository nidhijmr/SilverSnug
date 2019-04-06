package edu.sjsu.seekers.silversnug.response;

public class UserLocationResponse extends GenericResponse  {

    private static final long serialVersionUID = 2L;
    private String id;
    private String anomalyscore;
    private String datetime;
    private String latitude;
    private String longitude;
    private String patientusername;

    public UserLocationResponse(){}

    public UserLocationResponse(String status, String message, String id, String anomalyscore, String datetime, String latitude, String longitude, String patientusername) {
        super(status, message);
        this.id = id;
        this.anomalyscore = anomalyscore;
        this.datetime = datetime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.patientusername = patientusername;
    }

    public String getID(){
        return id;
    }

    public void setID(String id){
        this.id=id;
    }

    public String getAnomalyScore(){
        return anomalyscore;
    }

    public void setAnomalyScore(String anomalyscore){
        this.anomalyscore=anomalyscore;
    }

    public String getDateTime(){
        return datetime;
    }

    public void setDateTime(String datetime){
        this.datetime=datetime;
    }

    public String getLatitude(){
        return latitude;
    }

    public void setLatitude(String latitude){
        this.latitude=latitude;
    }

    public String getLongitude(){
        return longitude;
    }

    public void setLongitude(String longitude){
        this.longitude=longitude;
    }

    public String getUsername(){
        return patientusername;
    }

    public void setUsername(String patientusername){
        this.patientusername=patientusername;
    }

    @Override
    public String toString() {
        return "UserLocation{" +
                "id='" + id + '\'' +
                ", anomalyscore='" + anomalyscore + '\'' +
                ", datetime='" + datetime + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", patientusername='" + patientusername + '\'' +
                '}';
    }
}
