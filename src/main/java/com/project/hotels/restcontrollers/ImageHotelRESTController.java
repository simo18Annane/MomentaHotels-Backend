package com.project.hotels.restcontrollers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.hotels.entities.ImageHotel;
import com.project.hotels.services.ImageHotelService;

@RestController
@RequestMapping("/imageHotels")
@CrossOrigin
public class ImageHotelRESTController {

    @Autowired
    ImageHotelService imageHotelService;

    @PostMapping("/upload")
    public ImageHotel uploadImageHotel(@RequestParam("image")MultipartFile file) throws IOException {
        return imageHotelService.saveImageHotel(file);
    }

    @GetMapping("/getImageDetails/{id}")
    public ImageHotel getImageHotelDetails(@PathVariable("id") Long id) throws IOException {
        return imageHotelService.getImageHotelDetailsById(id);
    }

    @GetMapping("load/{id}")
    public ResponseEntity<byte[]> getImageHotel(@PathVariable("id") Long id) throws IOException {
        return imageHotelService.getImageHotelById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteImageHotel(@PathVariable("id") Long id) {
        imageHotelService.deleteImageHotel(id);
    }

}
