package edu.sjsu.seekers.silversnug.model;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "pillbox")
public class PillBox {

    private String userName;
    private String pillBoxId;
    private String medicineName;
    private String potency;
    private int dosage;
    private String notes;

    public PillBox()
    {

    }

    public PillBox(String userName, String pillBoxId, String medicineName, String potency, int dosage, String notes) {
        this.medicineName = medicineName;
        this.potency = potency;
        this.dosage = dosage;
        this.notes = notes;
    }


    @DynamoDBAttribute(attributeName = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @DynamoDBHashKey(attributeName = "pillboxId")
    public String getPillBoxId() {
        return pillBoxId;
    }

    public void setPillBoxId(String pillBoxId) {
        this.pillBoxId = pillBoxId;
    }

    @DynamoDBAttribute(attributeName = "medicineName")
    public String getMedicineName() {
        return medicineName;
    }


    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    @DynamoDBAttribute(attributeName = "potency")
    public String getPotency() {
        return potency;
    }

    public void setPotency(String potency) {
        this.potency = potency;
    }

    @DynamoDBAttribute(attributeName = "dosage")
    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    @DynamoDBAttribute(attributeName = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}

