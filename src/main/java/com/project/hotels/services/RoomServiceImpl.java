package com.project.hotels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hotels.entities.Room;
import com.project.hotels.repositories.RoomRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Override
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Room room) {
        roomRepository.delete(room);
    }

    @Override
    public void deleteRoomById(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public Room getRoomById(Long id) {
        Optional<Room> opt = roomRepository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        }
        throw new EntityNotFoundException("Room introuvable id=" + id);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

}
