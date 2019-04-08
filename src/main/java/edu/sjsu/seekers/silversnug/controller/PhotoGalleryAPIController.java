package edu.sjsu.seekers.silversnug.controller;


import edu.sjsu.seekers.silversnug.request.DeletePhotoRequest;
import edu.sjsu.seekers.silversnug.request.EditPhotoRequest;
import edu.sjsu.seekers.silversnug.request.PhotoGalleryRequest;
import edu.sjsu.seekers.silversnug.response.PhotoGalleryResponse;
import edu.sjsu.seekers.silversnug.response.GenericResponse;
import edu.sjsu.seekers.silversnug.service.PhotoGalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PhotoGalleryAPIController {

    @Autowired
    PhotoGalleryService photoGalleryService;

    @PostMapping("/SilverSnug/PhotoGallery/addPhoto")
    @ResponseBody
    public GenericResponse addPhoto(@RequestBody PhotoGalleryRequest request)
    {
        return photoGalleryService.savePhoto(request);
    }

    @GetMapping("/SilverSnug/PhotoGallery/getPhotoGallery")
    public PhotoGalleryResponse getPhotoGallery(String userId)
    {
        System.out.println(photoGalleryService.getPhotoGalleryByUserId(userId));
        return photoGalleryService.getPhotoGalleryByUserId(userId);
    }

    @PostMapping("/SilverSnug/PhotoGallery/deletePhoto")
    @ResponseBody
    public GenericResponse deletePhoto(@RequestBody DeletePhotoRequest request)
    {
        return photoGalleryService.deletePhoto(request);
    }

    @PostMapping("/SilverSnug/PhotoGallery/editPhoto")
    @ResponseBody
    public GenericResponse editPhoto(@RequestBody EditPhotoRequest request)
    {
        return photoGalleryService.editPhoto(request);
    }
}
