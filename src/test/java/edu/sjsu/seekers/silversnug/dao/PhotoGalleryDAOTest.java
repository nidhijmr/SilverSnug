package edu.sjsu.seekers.silversnug.dao;


import edu.sjsu.seekers.silversnug.model.PhotoGallery;
import edu.sjsu.seekers.silversnug.request.PhotoGalleryRequest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.Assert.*;



public class PhotoGalleryDAOTest {

    public static final String USER_ID="680cdb82-c044-4dd1-ae84-1a15e54ab502";

    PhotoGalleryDao photoGalleryDao;

    PhotoGalleryRequest photoGalleryRequest;

    PhotoGallery photoGallery, newPhotoGallery;

    @Before
    public void setup()
    {
        photoGalleryDao = new PhotoGalleryDao();
        photoGalleryDao.dynamodbClient = new DynamoDbClient();
        photoGalleryRequest = new PhotoGalleryRequest("680cdb82-c044-4dd1-ae84-1a15e54ab502", "s3://test/location","Sindhu","+14081234567", "Friend");

    }

    @Test
    public void save()
    {
        String uuid = UUID.randomUUID().toString();
        newPhotoGallery = new PhotoGallery("a07c639f-579a-4a08-b512-1dd88a6a274e","680cdb82-c044-4dd1-ae84-1a15e54ab502","s3://test/location","Sindhu","+14081234567", "Friend");
        photoGalleryDao.save(newPhotoGallery);

        PhotoGallery photoGalleryExisting = photoGalleryDao.getPhotoGalleryByUserId(USER_ID);
        if(photoGalleryExisting!=null)
        {
            System.out.println("Photo saved successfully" + photoGalleryExisting.getPhotoId());
            photoGalleryDao.deletePhoto(USER_ID,"a07c639f-579a-4a08-b512-1dd88a6a274e");
            assertEquals(photoGalleryExisting.getContactNumber(),newPhotoGallery.getContactNumber());
        }
        else
        {
            fail("test case failed");
        }
    }

    @Test
    public void getPhotoGalleryByUserId()
    {
        PhotoGallery photoGalleryExisting  = photoGalleryDao.getPhotoGalleryByUserId(USER_ID);

        if(photoGalleryExisting != null) {
            System.out.println("Photos fetched successfully: " + photoGalleryExisting.getContactNumber());
            assertEquals(photoGalleryExisting.getUserId(), USER_ID);
        }
        else{
            fail("test case failed");
        }
    }

}

