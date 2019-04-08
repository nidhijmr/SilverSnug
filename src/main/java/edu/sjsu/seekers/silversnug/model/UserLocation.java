package edu.sjsu.seekers.silversnug.model;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import java.util.UUID;

@DynamoDBTable(tableName = "userlocation")
public class UserLocation{
    private String id;
    private String anomalyScore;
    private String dateTime;
    private String latitude;
    private String longitude;
    private String patientUsername;

    public UserLocation(){}

    public UserLocation(String Id, String dateTime, String anomalyScore, String latitude, String longitude, String patientusername) {
        this.id = id;
        this.dateTime = dateTime;
        this.anomalyScore = anomalyScore;
        this.latitude = latitude;
        this.longitude = longitude;
        this.patientUsername = patientusername;
    }


    @DynamoDBHashKey(attributeName = "ID")
    public String getId(){
        return id;
    }

    public void setId(String Id){
        this.id=Id;
    }

    @DynamoDBAttribute(attributeName = "AnomalyScore")
    public String getAnomalyScore(){
        return anomalyScore;
    }

    public void setAnomalyScore(String anomalyScore){
        this.anomalyScore=anomalyScore;
    }

    @DynamoDBAttribute(attributeName = "DateTime")
    public String getDateTime(){
        return dateTime;
    }

    public void setDateTime(String datetime){
        this.dateTime=datetime;
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
    public String getPatientUsername(){
        return patientUsername;
    }

    public void setPatientUsername(String patientUsername){
        this.patientUsername=patientUsername;
    }

    @Override
    public String toString() {
        return "UserLocation{" +
                "Id='" + id + '\'' +
                ", anomalyscore='" + anomalyScore + '\'' +
                ", datetime='" + dateTime + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", patientusername='" + patientUsername + '\'' +
                '}';
    }
}
