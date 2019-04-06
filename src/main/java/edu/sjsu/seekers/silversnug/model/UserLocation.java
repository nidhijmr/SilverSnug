package edu.sjsu.seekers.silversnug.model;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

@DynamoDBTable(tableName = "userlocation")
public class UserLocation{
    private String id;
    private String anomalyscore;
    private String datetime;
    private String latitude;
    private String longitude;
    private String patientusername;

    public UserLocation(){}

    public UserLocation(String id, String anomalyscore, String datetime, String latitude, String longitude, String patientusername) {
        this.id = id;
        this.anomalyscore = anomalyscore;
        this.datetime = datetime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.patientusername = patientusername;
    }


    @DynamoDBHashKey(attributeName = "userlocationId")
    public String getID(){
        return id;
    }

    public void setID(String id){
        this.id=id;
    }

    @DynamoDBAttribute(attributeName = "AnomalyScore")
    public String getAnomalyScore(){
        return anomalyscore;
    }

    public void setAnomalyScore(String anomalyscore){
        this.anomalyscore=anomalyscore;
    }

    @DynamoDBAttribute(attributeName = "DateTime")
    public String getDateTime(){
        return datetime;
    }

    public void setDateTime(String datetime){
        this.datetime=datetime;
    }

    @DynamoDBAttribute(attributeName = "Latitude")
    public String getLatitude(){
        return latitude;
    }

    public void setLatitude(String latitude){
        this.latitude=latitude;
    }

    @DynamoDBAttribute(attributeName = "Longitude")
    public String getLongitude(){
        return longitude;
    }

    public void setLongitude(String longitude){
        this.longitude=longitude;
    }

    @DynamoDBAttribute(attributeName = "Patient_UserName")
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
