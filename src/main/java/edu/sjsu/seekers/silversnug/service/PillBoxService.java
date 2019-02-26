package edu.sjsu.seekers.silversnug.service;

import edu.sjsu.seekers.silversnug.dao.PillBoxDao;
import edu.sjsu.seekers.silversnug.model.PillBox;
import edu.sjsu.seekers.silversnug.request.DeletePillRequest;
import edu.sjsu.seekers.silversnug.request.EditPillRequest;
import edu.sjsu.seekers.silversnug.request.PillBoxRequest;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import edu.sjsu.seekers.silversnug.response.PillBoxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static edu.sjsu.seekers.silversnug.util.Constants.*;

@Service
public class PillBoxService {


    private final String SUCCESS = "SUCCESS";
    @Autowired
    PillBoxDao pillBoxDao;

    public void authenticate(String username) {
        System.out.println("In service: " + username);
        pillBoxDao.authenticate(username);
    }
    public GenericResponse savePill(PillBoxRequest request) {

        PillBox pillBox = new PillBox();
        pillBox.setUserName(request.getUserName());
        pillBox.setPillBoxId(request.getPillBoxId());
        pillBox.setMedicineName(request.getMedicineName());
        pillBox.setDosage(request.getDosage());
        pillBox.setPotency(request.getPotency());
        pillBox.setNotes(request.getNotes());
        pillBoxDao.save(pillBox);

        GenericResponse response = new GenericResponse();
        response.setMessage(PILL_ADD_SUCCESS);
        response.setStatus(HttpStatus.OK.toString());

        return response;
    }

    public PillBoxResponse getPillByUserName(String userName) {

        PillBoxResponse response = new PillBoxResponse();
        PillBox pillBox = pillBoxDao.getPillByUserName(userName);
        if (null != pillBox) {
            response.setUserName(pillBox.getUserName());
            response.setPillBoxId(pillBox.getPillBoxId());
            response.setMedicineName(pillBox.getMedicineName());
            response.setDosage(pillBox.getDosage());
            response.setNotes(pillBox.getNotes());
            response.setPotency(pillBox.getPotency());
            response.setMessage(SUCCESS);
        } else {
            response.setMessage(UNSUCCESSFUL_GET_PILL);
        }

        return response;

    }

    public GenericResponse deletePill(DeletePillRequest request) {

        GenericResponse response = new GenericResponse();

        PillBox pillBox = pillBoxDao.getPillByUserName(request.getUserName());
        if(null!=pillBox) {
            pillBoxDao.deletePill(request.getUserName(), request.getPillBoxId());

            response.setMessage(SUCCESS);
            response.setStatus(HttpStatus.OK.toString());
        }
        else
        {
            response.setMessage(UNSUCCESSFUL_PILL_USER);
        }

        return response;
    }


    public GenericResponse editPill(EditPillRequest request) {

        GenericResponse response = new GenericResponse();

        PillBox pillBox = pillBoxDao.getPillByUserName(request.getUserName());
        if(null!=pillBox) {
            pillBoxDao.editPill(request);

            response.setMessage(SUCCESS);
            response.setStatus(HttpStatus.OK.toString());
        }
        else
        {
            response.setMessage(UNSUCCESSFUL_PILL_USER);
        }

        return response;

    }
    }

