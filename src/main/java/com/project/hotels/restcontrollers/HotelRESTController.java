package com.project.hotels.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hotels.entities.Hotel;
import com.project.hotels.services.HotelService;

@RestController
@RequestMapping("/hotels")
@CrossOrigin
public class HotelRESTController {

    @Autowired
    HotelService hotelService;

    @PostMapping("/addHotel")
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelService.saveHotel(hotel);
    }

    @PutMapping("/updateHotel")
    public Hotel updateHotel(@RequestBody Hotel hotel) {
        return hotelService.updateHotel(hotel);
    }

    @DeleteMapping("/deleteHotel/{id}")
    public void deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotelById(id);
    }

    @GetMapping("/getHotel/{id}")
    public Hotel getHotel(@PathVariable Long id) {
        return hotelService.getHotelById(id);
    }

    @GetMapping("/allHotels")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

}
