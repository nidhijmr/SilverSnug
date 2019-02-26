package edu.sjsu.seekers.silversnug.request;
import java.io.Serializable;

public class DeletePillRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String pillBoxId;
    private String userName;

    public DeletePillRequest()
    {

    }


    public DeletePillRequest(String userName, String pillBoxId)
    {
        this.userName = userName;
        this.pillBoxId =  pillBoxId;
    }

    public String getPillBoxId() {
        return pillBoxId;
    }

    public void setPillBoxId(String pillBoxId) {
        this.pillBoxId = pillBoxId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "DeletePillRequest{" +
                "pillBoxId='" + pillBoxId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

}
