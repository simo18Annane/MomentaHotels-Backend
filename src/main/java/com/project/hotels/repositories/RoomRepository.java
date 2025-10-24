package com.project.hotels.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hotels.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
