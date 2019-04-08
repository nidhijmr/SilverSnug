package edu.sjsu.seekers.silversnug.service;

import edu.sjsu.seekers.silversnug.dao.PillBoxDao;
import edu.sjsu.seekers.silversnug.model.PillBox;
import edu.sjsu.seekers.silversnug.request.DeletePillRequest;
import edu.sjsu.seekers.silversnug.request.EditPillRequest;
import edu.sjsu.seekers.silversnug.request.PillBoxRequest;
import edu.sjsu.seekers.silversnug.response.AddressBookResponse;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import edu.sjsu.seekers.silversnug.response.PillBoxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

        String pillboxUUID = UUID.randomUUID().toString();
        PillBox pillBox = new PillBox();
        pillBox.setUserId(request.getUserId());
        pillBox.setPillBoxId(pillboxUUID);
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

    public PillBoxResponse getPillByUserId(String userId) {

        PillBoxResponse response = new PillBoxResponse();
        PillBoxResponse pillBoxResponse = pillBoxDao.getPillByUserId(userId);
        if (null != pillBoxResponse) {
            response = pillBoxResponse;
        } else {
            response.setMessage(UNSUCCESSFUL_PILL_USER);
        }

        return response;
    }


    public GenericResponse deletePill(String userId, String medicineName) {

        GenericResponse response = new GenericResponse();

        String pillId = pillBoxDao.getPillIdByPillName(userId,medicineName);
        if(pillId!=null) {
            pillBoxDao.deletePill(pillId);

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

        PillBoxResponse pillBox = pillBoxDao.getPillByUserId(request.getUserId());
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