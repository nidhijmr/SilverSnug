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


@Service
public class PhotoGalleryService {

    private final String SUCCESS = "SUCCESS";
    @Autowired
    PhotoGalleryDao photoGalleryDao;

    public GenericResponse savePhoto(PhotoGalleryRequest request )
    {
        PhotoGallery photoGallery = new PhotoGallery();
        photoGallery.setPhotoId(request.getPhotoId());
        photoGallery.setUserName(request.getUserName());
        photoGallery.setPhoto(request.getPhoto());
        photoGallery.setPhotoName(request.getPhotoName());
        photoGallery.setContactNumber(request.getContactNumber());
        photoGalleryDao.save(photoGallery);

        GenericResponse response = new GenericResponse();
        response.setMessage(SUCCESS);
        response.setStatus(HttpStatus.OK.toString());

        return response;
    }


    public PhotoGalleryResponse getPhotoGalleryByUserName(String userName)
    {
        PhotoGalleryResponse response = new PhotoGalleryResponse();

        PhotoGallery photoGallery = photoGalleryDao.getPhotoGalleryByUserName(userName);
        if(null!=photoGallery)
        {
            response.setPhotoId(photoGallery.getPhotoId());
            response.setUserName(photoGallery.getUserName());
            response.setPhoto(photoGallery.getPhoto());
            response.setPhotoName(photoGallery.getPhotoName());
            response.setContactNumber(photoGallery.getContactNumber());
            response.setMessage(SUCCESS);
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

        PhotoGallery photoGallery = photoGalleryDao.getPhotoGalleryByUserName(request.getUserName());
        if(null!=photoGallery) {
            photoGalleryDao.deletePhoto(request.getUserName(), request.getPhotoId());

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

        PhotoGallery photoGallery = photoGalleryDao.getPhotoGalleryByUserName(request.getUserName());
        if(null!=photoGallery) {
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
