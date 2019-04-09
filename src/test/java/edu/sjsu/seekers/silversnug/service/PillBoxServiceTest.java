package edu.sjsu.seekers.silversnug.service;

import edu.sjsu.seekers.silversnug.controller.PillBoxAPIController;
import edu.sjsu.seekers.silversnug.dao.PillBoxDao;
import edu.sjsu.seekers.silversnug.model.PillBox;
import edu.sjsu.seekers.silversnug.request.DeletePillRequest;
import edu.sjsu.seekers.silversnug.request.EditPillRequest;
import edu.sjsu.seekers.silversnug.request.PillBoxRequest;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import edu.sjsu.seekers.silversnug.response.PillBoxResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

public class PillBoxServiceTest {

    public static final String USER_ID = "680cdb82-c044-4dd1-ae84-1a15e54ab502";

    PillBoxService pillBoxService;

    PillBoxRequest pillBoxRequest;

    PillBoxResponse pillBoxResponse, pillBoxResponseFinal;

    PillBoxAPIController pillBoxAPIController;

    GenericResponse genericResponse, genericResponseFinal;

    DeletePillRequest deletePillRequest;

    EditPillRequest editPillRequest;

    PillBox pillBox;
    private String TEST_PILL = "TestPillName";

    @Before
    public void setup() {
        String pillUUID = UUID.randomUUID().toString();
        pillBoxService = new PillBoxService();
        pillBox = new PillBox(pillUUID, "680cdb82-c044-4dd1-ae84-1a15e54ab502", "citrizine", "250mg", "200", "twice a day");
        pillBoxRequest = new PillBoxRequest(pillUUID, "680cdb82-c044-4dd1-ae84-1a15e54ab502", "citrizine", "250mg", "200", "twice a day");

        List<PillBox> pills = new ArrayList<PillBox>();
        String photoUUID = UUID.randomUUID().toString();
        pills.add(new PillBox(pillUUID, "680cdb82-c044-4dd1-ae84-1a15e54ab502", "citrizine", "250mg", "200", "twice a day"));
        pillBoxResponse = new PillBoxResponse(pills);
        pillBoxService.pillBoxDao = mock(PillBoxDao.class);
    }

    @Test
    public void save() {
        {
            PillBoxRequest request = mock(PillBoxRequest.class);

            GenericResponse result = pillBoxService.savePill(request);

            if (result != null) {
                assertEquals(result.getMessage(), "pill added sucessfully");
                assertEquals(result.getStatus(), HttpStatus.OK.toString());
            } else {
                assertFalse("Unable to find the pill Object ", true);
            }

        }
    }

    @Test
    public void getPIll()
    {
        List<PillBox> addList = new ArrayList<PillBox>();
        String pillUUID = UUID.randomUUID().toString();
        addList.add(new PillBox(USER_ID,pillUUID,TEST_PILL, "250mg", "200", "twice a day"));
        PillBoxResponse response = new PillBoxResponse(addList);
        pillBoxService.pillBoxDao.getPillIdByPillName(USER_ID,TEST_PILL);
        PillBoxResponse result = pillBoxService.getPillByUserId(USER_ID);


        if(result!=null){
            assertEquals(result.getMessage(),"pills not found for this User");
        }
        else {
            assertFalse("Unable to find the pillbook Object ",true);
        }
    }

}