package edu.sjsu.seekers.silversnug.response;

import java.io.Serializable;

public class GenericResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    String status;
    String message;

    public GenericResponse() {
    }

    public GenericResponse(String status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "GenericResponse [status=" + status + ", message=" + message + "]";
    }
}
