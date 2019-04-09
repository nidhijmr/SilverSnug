package edu.sjsu.seekers.silversnug.controller;

import edu.sjsu.seekers.silversnug.model.PillBox;
import edu.sjsu.seekers.silversnug.request.DeletePillRequest;
import edu.sjsu.seekers.silversnug.request.EditPillRequest;
import edu.sjsu.seekers.silversnug.request.PillBoxRequest;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import edu.sjsu.seekers.silversnug.response.PillBoxResponse;
import edu.sjsu.seekers.silversnug.service.PhotoGalleryService;
import edu.sjsu.seekers.silversnug.service.PillBoxService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PillBoxControllerTest {

    public static final String USER_ID = "680cdb82-c044-4dd1-ae84-1a15e54ab502";

    @MockBean
    PillBoxService pillBoxService;

    PillBoxResponse pillBoxResponse, pillBoxResponseFinal;

    PillBoxAPIController pillBoxAPIController;

    GenericResponse genericResponse, genericResponseFinal;

    DeletePillRequest deletePillRequest;

    EditPillRequest editPillRequest;
    private String TEST_PILL = "TestPillName";


    @Before
    public void setup() {
        System.out.println("Setting up test");
        List<PillBox> pill = new ArrayList<PillBox>();
        String pillUUID = UUID.randomUUID().toString();
        pill.add(new PillBox(pillUUID, "680cdb82-c044-4dd1-ae84-1a15e54ab502", "citrizine", "250mg", "200", "twice a day"));

        pillBoxResponse = new PillBoxResponse(pill);
        genericResponse = new GenericResponse("200", "success");
        pillBoxAPIController = new PillBoxAPIController();
        pillBoxAPIController.pillBoxService = mock(PillBoxService.class);
    }


    @Test
    public void savePill() {
        GenericResponse response = new GenericResponse();
        response.setMessage("SUCCESS");
        response.setStatus(HttpStatus.OK.toString());

        PillBoxRequest request = mock(PillBoxRequest.class);
        when(pillBoxAPIController.addPill(request)).thenReturn(response);

        GenericResponse result = pillBoxAPIController.addPill(request);

        if (result != null) {
            assertEquals(result.getMessage(), "SUCCESS");
            assertEquals(result.getStatus(), HttpStatus.OK.toString());
        } else {
            assertFalse("Unable to find the Pill ", true);
        }

    }

    @Test
    public void getPill() {
        when(pillBoxAPIController.pillBoxService.getPillByUserId(USER_ID)).thenReturn(pillBoxResponse);

        pillBoxResponseFinal = pillBoxAPIController.getPill(USER_ID);

        assertEquals(pillBoxResponseFinal.getPillBoxes().get(0).getMedicineName(), pillBoxResponse.getPillBoxes().get(0).getMedicineName());
        assertEquals(pillBoxResponseFinal.getPillBoxes().get(0).getDosage(), pillBoxResponse.getPillBoxes().get(0).getDosage());
        assertEquals(pillBoxResponseFinal.getPillBoxes().get(0).getPotency(), pillBoxResponse.getPillBoxes().get(0).getPotency());
        assertEquals(pillBoxResponseFinal.getPillBoxes().get(0).getNotes(), pillBoxResponse.getPillBoxes().get(0).getNotes());


    }

    @Test
    public void deletePill() {
        when(pillBoxAPIController.pillBoxService.deletePill(USER_ID, TEST_PILL)).thenReturn(genericResponse);

        genericResponseFinal = pillBoxAPIController.deletepill(USER_ID, TEST_PILL);

        assertEquals(genericResponseFinal.getMessage(), genericResponse.getMessage());
        assertEquals(genericResponseFinal.getStatus(), genericResponse.getStatus());
    }

    @Test
    public void editPill() {
        PillBoxRequest pillBoxRequest = mock(PillBoxRequest.class);
        when(pillBoxAPIController.pillBoxService.editPill(editPillRequest)).thenReturn(genericResponse);

        genericResponseFinal = pillBoxAPIController.editPill(editPillRequest);

        assertEquals(genericResponseFinal.getMessage(), genericResponse.getMessage());
        assertEquals(genericResponseFinal.getStatus(), genericResponse.getStatus());

    }

}