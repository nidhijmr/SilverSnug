package edu.sjsu.seekers.silversnug.controller;

import edu.sjsu.seekers.silversnug.request.PhotoGalleryRequest;
import edu.sjsu.seekers.silversnug.request.EditPhotoRequest;
import edu.sjsu.seekers.silversnug.request.DeletePhotoRequest ;
import edu.sjsu.seekers.silversnug.response.PhotoGalleryResponse;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import edu.sjsu.seekers.silversnug.service.PhotoGalleryService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class PhotoGalleryControllerTest {

    public static final String USER_ID="680cdb82-c044-4dd1-ae84-1a15e54ab502";
    @MockBean
    PhotoGalleryService photoGalleryService;

    PhotoGalleryResponse photoGalleryResponse, photoGalleryResponseFinal;

    PhotoGalleryAPIController photoGalleryAPIController;

    GenericResponse genericResponse, genericResponseFinal;

    DeletePhotoRequest deletePhotoRequest;

    EditPhotoRequest editPhotoRequest;


    @Before
    public void setup()
    {
        System.out.println("Setting up test");
       photoGalleryResponse = new PhotoGalleryResponse("a07c639f-579a-4a08-b512-1dd88a6a274e", "a07c639f-579a-4a08-b512-1dd88a6a274e", "s3://test/location","Sindhu","+14081234567", "Friend" );
        genericResponse = new GenericResponse("200","success");
        photoGalleryAPIController = new PhotoGalleryAPIController();
        photoGalleryAPIController.photoGalleryService = mock(PhotoGalleryService.class);
    }

    @Test
    public void savePhoto()
    {
        PhotoGalleryRequest photoGalleryRequest = mock(PhotoGalleryRequest.class);
        when(photoGalleryAPIController.photoGalleryService.savePhoto(photoGalleryRequest)).thenReturn(photoGalleryResponse);

        genericResponseFinal = photoGalleryAPIController.addPhoto(photoGalleryRequest);

        assertEquals(genericResponseFinal.getMessage(),genericResponse.getMessage());
        assertEquals(genericResponseFinal.getStatus(), genericResponse.getStatus());

    }

    @Test
    public void getPhotoGallery()
    {
        when(photoGalleryAPIController.photoGalleryService.getPhotoGalleryByUserId(USER_ID)).thenReturn(photoGalleryResponse);

        photoGalleryResponseFinal= photoGalleryAPIController.getPhotoGallery(USER_ID);

        assertEquals(photoGalleryResponseFinal.getContactNumber(),photoGalleryResponse.getContactNumber());
        assertEquals(photoGalleryResponseFinal.getPhotoName(),photoGalleryResponse.getPhotoName());

    }

    @Test
    public void deletePhoto()
    {
        when(photoGalleryAPIController.photoGalleryService.deletePhoto(deletePhotoRequest)).thenReturn(genericResponse);

        genericResponseFinal = photoGalleryAPIController.deletePhoto(deletePhotoRequest);

        assertEquals(genericResponseFinal.getMessage(),genericResponse.getMessage());
        assertEquals(genericResponseFinal.getStatus(), genericResponse.getStatus());
    }

    @Test
    public void editPhoto()
    {
        PhotoGalleryRequest photoGalleryRequest = mock(PhotoGalleryRequest.class);
        when(photoGalleryAPIController.photoGalleryService.editPhoto(editPhotoRequest)).thenReturn(genericResponse);

        genericResponseFinal = photoGalleryAPIController.editPhoto(editPhotoRequest);

        assertEquals(genericResponseFinal.getMessage(),genericResponse.getMessage());
        assertEquals(genericResponseFinal.getStatus(),genericResponse.getStatus());
    }

}
