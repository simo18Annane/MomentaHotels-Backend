package com.project.hotels.services;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.project.hotels.entities.ImageHotel;

public interface ImageHotelService {

    ImageHotel saveImageHotel(MultipartFile file) throws IOException;
    ImageHotel getImageHotelDetailsById(Long id) throws IOException;
    ResponseEntity<byte[]> getImageHotelById(Long id) throws IOException;
    void deleteImageHotel(Long id);

}
