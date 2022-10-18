package com.reto3.reto3.Servicio;

import com.reto3.reto3.Entidad.Room;
import com.reto3.reto3.Entidad.Room;
import com.reto3.reto3.Repositorio.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Room updateRoom(Room room) {



        if (room.getId() != null) {
            Optional<Room> roomU = repository.findById(room.getId());



            if (!roomU.isEmpty()) {



                for (Field f : room.getClass().getDeclaredFields()) {
                    f.setAccessible(true);
                    Object value;
                    try {
                        value = f.get(room);
                        if (value != null) {
                            System.out.println("entro");
                            f.set(roomU.get(), value);
                        }
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            return repository.save(roomU.get());
        }
        return room;
    }

    public boolean deleteRoom(int id) {
        Optional<Room> roomd = repository.findById(id);
        if (roomd.isEmpty()) {
            return false;
        } else {
            repository.delete(roomd.get());
            return true;
        }
    }
}
