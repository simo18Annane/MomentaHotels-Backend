package com.project.hotels.services;

import java.util.List;

import com.project.hotels.entities.Room;

public interface RoomService {

    Room saveRoom(Room room);
    Room updateRoom(Room room);
    void deleteRoom(Room room);
    void deleteRoomById(Long id);
    Room getRoomById(Long id);
    List<Room> getAllRooms();

}
