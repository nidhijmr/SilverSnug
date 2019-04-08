package edu.sjsu.seekers.silversnug.service;

import edu.sjsu.seekers.silversnug.controller.PhotoGalleryAPIController;
import edu.sjsu.seekers.silversnug.dao.PhotoGalleryDao;
import edu.sjsu.seekers.silversnug.model.PhotoGallery;
import edu.sjsu.seekers.silversnug.request.PhotoGalleryRequest;
import edu.sjsu.seekers.silversnug.request.EditPhotoRequest;
import edu.sjsu.seekers.silversnug.request.DeletePhotoRequest;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import edu.sjsu.seekers.silversnug.response.PhotoGalleryResponse;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static edu.sjsu.seekers.silversnug.util.Constants.USER_ADD_SUCCESS;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PhotoGalleryServiceTest {

    public static final String USER_ID="680cdb82-c044-4dd1-ae84-1a15e54ab502";

    PhotoGalleryService photoGalleryService;

    PhotoGalleryRequest photoGalleryRequest;

    PhotoGalleryResponse photoGalleryResponse, photoGalleryResponseFinal;

    PhotoGalleryAPIController photoGalleryAPIController;

    GenericResponse genericResponse, genericResponseFinal;

    DeletePhotoRequest deletePhotoRequest;

    EditPhotoRequest editPhotoRequest;

    PhotoGallery photoGallery;

    @Before
    public void setup()
    {
        photoGalleryService = new PhotoGalleryService();
        photoGallery = new PhotoGallery("a07c639f-579a-4a08-b512-1dd88a6a274e", "a07c639f-579a-4a08-b512-1dd88a6a274e", "s3://test/location","Sindhu","+14081234567", "Friend" );
        photoGalleryRequest = new PhotoGalleryRequest("a07c639f-579a-4a08-b512-1dd88a6a274e", "https://s3.amazonaws.com/silversnugphotos/photos/18325499-c88c-4230-a27c-ef9122172a0f.png","Sindhu","+14081234567", "Friend" );

        List<PhotoGallery> photos = new ArrayList<PhotoGallery>();
        String photoUUID = UUID.randomUUID().toString();
        photos.add(new PhotoGallery(photoUUID,"680cdb82-c044-4dd1-ae84-1a15e54ab502","https://s3.amazonaws.com/silversnugphotos/photos/18325499-c88c-4230-a27c-ef9122172a0f.png","Sindhu","Friend","+1 408 1234567"));
        photoGalleryResponse = new PhotoGalleryResponse(photos);
        photoGalleryService.photoGalleryDao = mock(PhotoGalleryDao.class);
    }

    @Test
    public void save()
    {
        when(photoGalleryService.photoGalleryDao.getPhotoGalleryByUserId(USER_ID)).thenReturn(null);
        photoGalleryService.photoGalleryDao = mock(PhotoGalleryDao.class);
        genericResponse = photoGalleryService.savePhoto(photoGalleryRequest);

        assertEquals(genericResponse.getMessage(),"SUCCESS");
        assertEquals(genericResponse.getStatus(), HttpStatus.OK.toString());
    }

    @Test
    public void getPhotoGalleryByUserId()
    {
        when(photoGalleryService.photoGalleryDao.getPhotoGalleryByUserId(USER_ID)).thenReturn(photoGalleryResponse);
        photoGalleryResponseFinal = photoGalleryService.getPhotoGalleryByUserId(USER_ID);

        assertEquals(photoGalleryResponseFinal.getPhotos().get(0).getContactNumber(),photoGalleryResponse.getPhotos().get(0).getContactNumber());
        assertEquals(photoGalleryResponseFinal.getPhotos().get(0).getPhotoName(), photoGalleryResponse.getPhotos().get(0).getPhotoName());
    }

    @Test
    public void editPhoto()
    {
        when(photoGalleryService.photoGalleryDao.getPhotoGalleryByUserId(photoGallery.getContactNumber())).thenReturn(null);
        photoGalleryService.photoGalleryDao = mock(PhotoGalleryDao.class);
        genericResponse = photoGalleryService.savePhoto(photoGalleryRequest);

        assertEquals(genericResponse.getMessage(),"SUCCESS");
        assertEquals(genericResponse.getStatus(), HttpStatus.OK.toString());

    }
}
