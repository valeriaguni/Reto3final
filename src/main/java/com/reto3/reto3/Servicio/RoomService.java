package com.reto3.reto3.Servicio;

import com.reto3.reto3.Entidad.Room;
import com.reto3.reto3.Repositorio.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository repository;

    public List<Room> getRooms(){
        return repository.findAll();
    }

    public Room saveRoom(Room room){
        return repository.save(room);
    }
}
