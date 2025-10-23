package com.project.hotels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hotels.entities.Hotel;
import com.project.hotels.repositories.HotelRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public void deleteHotel(Hotel hotel) {
        hotelRepository.delete(hotel);
    }

    @Override
    public void deleteHotelById(Long id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public Hotel getHotelById(Long id) {
        Optional<Hotel> opt = hotelRepository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        }
        throw new EntityNotFoundException("Hotel introuvable id=" + id);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

}
