package com.project.hotels.services;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.hotels.entities.ImageHotel;
import com.project.hotels.repositories.ImageHotelRepository;

@Service
public class ImageHotelServiceImpl implements ImageHotelService {

    @Autowired
    private ImageHotelRepository imageHotelRepository;

    @Override
    public ImageHotel saveImageHotel(MultipartFile file) throws IOException {
        return imageHotelRepository.save(ImageHotel.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .data(file.getBytes())
                .build());
    }

    @Override
    public ImageHotel getImageHotelDetailsById(Long id) throws IOException {
        final Optional<ImageHotel> dbImageHotel = imageHotelRepository.findById(id);
        return ImageHotel.builder()
                .id(dbImageHotel.get().getId())
                .name(dbImageHotel.get().getName())
                .type(dbImageHotel.get().getType())
                .data(dbImageHotel.get().getData())
                .build();
    }

    @Override
    public ResponseEntity<byte[]> getImageHotelById(Long id) throws IOException {
        final Optional<ImageHotel> dbImageHotel = imageHotelRepository.findById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(dbImageHotel.get().getType()))
                .body(dbImageHotel.get().getData());
    }

    @Override
    public void deleteImageHotel(Long id) {
        imageHotelRepository.deleteById(id);
    }

}
