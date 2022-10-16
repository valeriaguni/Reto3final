package com.reto3.reto3.Controlador;

import com.reto3.reto3.Entidad.Room;
import com.reto3.reto3.Servicio.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/Room")
public class RoomController {

    @Autowired
    private RoomService service;

    @GetMapping("/all")
    public List<Room> findAllRooms(){
        return service.getRooms();
    }

    @PostMapping("/save")
    public ResponseEntity saveRoom(@RequestBody Room room){
        service.saveRoom(room);
        return ResponseEntity.status(201).build();
    }
}
