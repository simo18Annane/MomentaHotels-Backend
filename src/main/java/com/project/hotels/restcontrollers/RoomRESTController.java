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

import com.project.hotels.entities.Room;
import com.project.hotels.services.RoomService;

@RestController
@RequestMapping("/rooms")
@CrossOrigin
public class RoomRESTController {

    @Autowired
    RoomService roomService;
    
    @PostMapping("/addRoom")
    public Room createRoom(@RequestBody Room room) {
        return roomService.saveRoom(room);
    }

    @PutMapping("/updateRoom")
    public Room updateRoom(@RequestBody Room room) {
        return roomService.updateRoom(room);
    }

    @DeleteMapping("/deleteRoom/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoomById(id);
    }

    @GetMapping("/getRoom/{id}")
    public Room getRoom(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }

    @GetMapping("/allRooms")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

}
