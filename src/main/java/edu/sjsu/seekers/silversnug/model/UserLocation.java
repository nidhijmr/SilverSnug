package edu.sjsu.seekers.silversnug.model;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import java.util.UUID;

@DynamoDBTable(tableName = "userlocation")
public class UserLocation{
    private String Id;
    private String anomalyscore;
    private String datetime;
    private String latitude;
    private String longitude;
    private String patientusername;

    public UserLocation(){}

    public UserLocation(String Id, String anomalyscore, String datetime, String latitude, String longitude, String patientusername) {
        this.Id = Id;
        this.anomalyscore = anomalyscore;
        this.datetime = datetime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.patientusername = patientusername;
    }


    @DynamoDBHashKey(attributeName = "ID")
    public String getId(){
        return Id;
    }

    public void setId(String Id){
        this.Id=Id;
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
                "Id='" + Id + '\'' +
                ", anomalyscore='" + anomalyscore + '\'' +
                ", datetime='" + datetime + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", patientusername='" + patientusername + '\'' +
                '}';
    }
}
