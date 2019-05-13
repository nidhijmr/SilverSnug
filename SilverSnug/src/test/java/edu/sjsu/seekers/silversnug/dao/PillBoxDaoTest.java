package edu.sjsu.seekers.silversnug.dao;

import edu.sjsu.seekers.silversnug.model.PillBox;
import edu.sjsu.seekers.silversnug.request.PillBoxRequest;
import edu.sjsu.seekers.silversnug.response.PillBoxResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.Fail.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PillBoxDaoTest {

    public static final String USER_ID = "680cdb82-c044-4dd1-ae84-1a15e54ab502";

    PillBoxDao pillBoxDao;

    PillBoxRequest pillBoxRequest;

    private String TEST_PILL = "TestPillName";
    PillBox pillBox, newPillBox;

    @Before
    public void setup() {
        pillBoxDao = new PillBoxDao();
        pillBoxDao.dynamodbClient = new DynamoDbClient();
        pillBoxRequest = new PillBoxRequest("680cdb82-c044-4dd1-ae84-1a15e54ab502", "d428a8ee-d640-4ed0-94ea-be5d359700e9", "citrizine", "250mg", "200", "Thrice a week");

    }

    @Test
    public void save() {
        String pillUUID = UUID.randomUUID().toString();
        System.out.println(pillUUID);
        PillBox pillBox = new PillBox(USER_ID, pillUUID, TEST_PILL, "250mg", "200", "twice a day");

        pillBoxDao.save(pillBox);

        /* PillBox result = pillBoxDao.getPillIdByPillName(USER_ID,TEST_PILL);*/
       /* if (result != null) {
            assertEquals(result.getPillBoxId(),pillUUID);
            assertEquals(result.getMedicineName(),"citrizine");
            assertEquals(result.getPotency(),"250mg");
        }*/
        /*else {
            assertFalse("Unable to find the Pill Object ",true);
        }
        pillBoxDao.deletePill(pillUUID);
    }
*/
    }

    @Test
    public void getPillByUserId()
    {
        PillBoxResponse pillBoxExisting  = pillBoxDao.getPillByUserId(USER_ID);

        if(pillBoxExisting != null) {
            System.out.println("pills fetched successfully: " + pillBoxExisting.getPillBoxes().get(0).getMedicineName());
            assertEquals(pillBoxExisting.getPillBoxes().get(0).getUserId(), USER_ID);
        }
        else{
            fail("test case failed");
        }
    }
}
