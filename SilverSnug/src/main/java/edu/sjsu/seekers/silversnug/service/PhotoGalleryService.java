package edu.sjsu.seekers.silversnug.service;

import edu.sjsu.seekers.silversnug.dao.PhotoGalleryDao;
import edu.sjsu.seekers.silversnug.model.PhotoGallery;
import edu.sjsu.seekers.silversnug.request.DeletePhotoRequest;
import edu.sjsu.seekers.silversnug.request.EditPhotoRequest;
import edu.sjsu.seekers.silversnug.request.PhotoGalleryRequest;
import edu.sjsu.seekers.silversnug.response.PhotoGalleryResponse;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.UUID;


@Service
public class PhotoGalleryService {

    private final String SUCCESS = "SUCCESS";
    @Autowired
    PhotoGalleryDao photoGalleryDao;

    public GenericResponse savePhoto(PhotoGalleryRequest request )
    {
        String photoGalleryUUID = UUID.randomUUID().toString();
        PhotoGallery photoGallery = new PhotoGallery();
        photoGallery.setPhotoId(photoGalleryUUID);
        photoGallery.setUserId(request.getUserId());
        photoGallery.setPhoto(request.getPhoto());
        photoGallery.setPhotoName(request.getPhotoName());
        photoGallery.setContactNumber(request.getContactNumber());
        photoGallery.setRelationship(request.getRelationship());
        photoGalleryDao.save(photoGallery);

        GenericResponse response = new GenericResponse();
        response.setMessage(SUCCESS);
        response.setStatus(HttpStatus.OK.toString());

        return response;
    }

    public PhotoGalleryResponse getPhotoGalleryByUserId(String userId)
    {
        PhotoGalleryResponse response = new PhotoGalleryResponse();

        PhotoGalleryResponse photoGalleryResponse = photoGalleryDao.getPhotoGalleryByUserId(userId);
        if(null!=photoGalleryResponse)
        {
            System.out.println("Response = " + photoGalleryResponse);
            response= photoGalleryResponse;
            /*response.setPhotoId(photoGallery.getPhotoId());
            response.setUserId(photoGallery.getUserId());
            response.setPhoto(photoGallery.getPhoto());
            response.setPhotoName(photoGallery.getPhotoName());
            response.setContactNumber(photoGallery.getContactNumber());
            response.setRelationship(photoGallery.getRelationship());
            response.setMessage(SUCCESS);*/
        }
        else
        {
            response.setMessage("photos not found for this User.");
        }

        return response;
    }


    public GenericResponse deletePhoto(DeletePhotoRequest request)
    {
        GenericResponse response = new GenericResponse();

        PhotoGalleryResponse photoGalleryResponse = photoGalleryDao.getPhotoGalleryByUserId(request.getUserId());
        if(null!=photoGalleryResponse) {
            photoGalleryDao.deletePhoto(request.getUserId(), request.getPhotoName());

            response.setMessage(SUCCESS);
            response.setStatus(HttpStatus.OK.toString());
        }
        else
        {
            response.setMessage("photos not found for this User.");
        }

        return response;
    }

    public GenericResponse editPhoto(EditPhotoRequest request)
    {
        GenericResponse response = new GenericResponse();

        PhotoGalleryResponse photoGalleryResponse = photoGalleryDao.getPhotoGalleryByUserId(request.getUserId());
        if(null!=photoGalleryResponse) {
            photoGalleryDao.editPhoto(request);

            response.setMessage(SUCCESS);
            response.setStatus(HttpStatus.OK.toString());
        }
        else
        {
            response.setMessage("photos not found for this User.");
        }

        return response;

    }



}
