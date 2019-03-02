package edu.sjsu.seekers.silversnug.request;

import java.io.Serializable;

public class EditPillRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String userId;
    private String medicineName;
    private String potency;
    private String dosage;
    private String notes;

    public EditPillRequest()
    {

    }


    public EditPillRequest(String medicineName, String potency, String dosage, String notes)
    {
        this.medicineName = medicineName;
        this.potency= potency;
        this.dosage = dosage;
        this.notes = notes;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getPotency() {
        return potency;
    }

    public void setPotency(String potency) {
        this.potency = potency;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "EditPillRequest{" +
                "userId='" + userId + '\'' +
                ", medicineName='" + medicineName + '\'' +
                ", potency='" + potency + '\'' +
                ", dosage=" + dosage +
                ", notes='" + notes + '\'' +
                '}';
    }
}
