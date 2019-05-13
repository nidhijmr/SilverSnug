package edu.sjsu.seekers.silversnug.request;
import java.io.Serializable;

public class DeletePillRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String pillBoxId;
    private String userId;

    public DeletePillRequest()
    {

    }


    public DeletePillRequest(String userId, String pillBoxId)
    {
        this.userId = userId;
        this.pillBoxId =  pillBoxId;
    }

    public String getPillBoxId() {
        return pillBoxId;
    }

    public void setPillBoxId(String pillBoxId) {
        this.pillBoxId = pillBoxId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "DeletePillRequest{" +
                "pillBoxId='" + pillBoxId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

}
