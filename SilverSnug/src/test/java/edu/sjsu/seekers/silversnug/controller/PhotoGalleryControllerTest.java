package edu.sjsu.seekers.silversnug.controller;

import edu.sjsu.seekers.silversnug.model.PhotoGallery;
import edu.sjsu.seekers.silversnug.request.PhotoGalleryRequest;
import edu.sjsu.seekers.silversnug.request.EditPhotoRequest;
import edu.sjsu.seekers.silversnug.request.DeletePhotoRequest ;
import edu.sjsu.seekers.silversnug.response.PhotoGalleryResponse;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import edu.sjsu.seekers.silversnug.service.PhotoGalleryService;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
        List<PhotoGallery> photos = new ArrayList<PhotoGallery>();
        String photoUUID = UUID.randomUUID().toString();
        photos.add(new PhotoGallery(photoUUID,"680cdb82-c044-4dd1-ae84-1a15e54ab502","https://s3.amazonaws.com/silversnugphotos/photos/18325499-c88c-4230-a27c-ef9122172a0f.png","Sindhu","Friend","+1 408 1234567"));

        photoGalleryResponse = new PhotoGalleryResponse(photos);
        genericResponse = new GenericResponse("200","success");
        photoGalleryAPIController = new PhotoGalleryAPIController();
        photoGalleryAPIController.photoGalleryService = mock(PhotoGalleryService.class);
    }

    @Test
    public void savePhoto()
    {
       GenericResponse response = new GenericResponse();
        response.setMessage("SUCCESS");
        response.setStatus(HttpStatus.OK.toString());

        PhotoGalleryRequest request = mock(PhotoGalleryRequest.class);
        when(photoGalleryAPIController.addPhoto(request)).thenReturn(response);

        GenericResponse result = photoGalleryAPIController.addPhoto(request);

        if(result!=null){
            assertEquals(result.getMessage(),"SUCCESS");
            assertEquals(result.getStatus(),HttpStatus.OK.toString());
        }
        else {
            assertFalse("Unable to find the PhotoGallery ",true);
        }

    }

    @Test
    public void getPhotoGallery()
    {
        when(photoGalleryAPIController.photoGalleryService.getPhotoGalleryByUserId(USER_ID)).thenReturn(photoGalleryResponse);

        photoGalleryResponseFinal= photoGalleryAPIController.getPhotoGallery(USER_ID);

        assertEquals(photoGalleryResponseFinal.getPhotos().get(0).getContactNumber(),photoGalleryResponse.getPhotos().get(0).getContactNumber());
        assertEquals(photoGalleryResponseFinal.getPhotos().get(0).getPhotoName(),photoGalleryResponse.getPhotos().get(0).getPhotoName());

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
