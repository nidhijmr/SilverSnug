package edu.sjsu.seekers.silversnug.response;

import edu.sjsu.seekers.silversnug.model.PillBox;

import java.util.List;

public class PillBoxResponse extends GenericResponse {

    private static final long serialVersionUID = 1L;

    private List<PillBox> pillBoxes;

    public PillBoxResponse(){

    }

    public PillBoxResponse(List<PillBox> pillBoxes) {
        super();
        this.pillBoxes = pillBoxes;
    }

    public List<PillBox> getPillBoxes() {
        return pillBoxes;
    }

    public void setPillBoxes(List<PillBox> pillBoxes) {
        this.pillBoxes = pillBoxes;
    }

    @Override
    public String toString() {
        return "PillBoxResponse{" +
                "PillBox=" + pillBoxes +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}


