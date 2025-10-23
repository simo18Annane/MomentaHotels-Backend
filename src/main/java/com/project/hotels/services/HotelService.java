package com.project.hotels.services;

import java.util.List;

import com.project.hotels.entities.Hotel;

public interface HotelService {

    Hotel saveHotel(Hotel hotel);
    Hotel updateHotel(Hotel hotel);
    void deleteHotel(Hotel hotel);
    void deleteHotelById(Long id);
    Hotel getHotelById(Long id);
    List<Hotel> getAllHotels();

}
