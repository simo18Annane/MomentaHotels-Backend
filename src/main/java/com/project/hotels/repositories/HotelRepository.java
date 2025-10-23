package com.project.hotels.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hotels.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
