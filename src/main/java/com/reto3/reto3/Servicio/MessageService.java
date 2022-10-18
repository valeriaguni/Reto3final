package com.reto3.reto3.Servicio;

import com.reto3.reto3.Entidad.Message;
import com.reto3.reto3.Repositorio.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;

    public List<Message> getMessages(){
        return repository.findAll();
    }

    public Message saveMessage(Message message){
        return repository.save(message);
    }

    public Message updateMessage(Message message) {



        if (message.getIdMessage() != null) {
            Optional<Message> messageU = repository.findById(message.getIdMessage());



            if (!messageU.isEmpty()) {



                for (Field f : message.getClass().getDeclaredFields()) {
                    f.setAccessible(true);
                    Object value;
                    try {
                        value = f.get(message);
                        if (value != null) {
                            System.out.println("entro");
                            f.set(messageU.get(), value);
                        }
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            return repository.save(messageU.get());
        }
        return message;
    }

    public boolean deleteMessage(int id) {
        Optional<Message> messaged = repository.findById(id);
        if (messaged.isEmpty()) {
            return false;
        } else {
            repository.delete(messaged.get());
            return true;
        }
    }
}
