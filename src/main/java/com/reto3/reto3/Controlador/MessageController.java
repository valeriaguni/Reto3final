package com.reto3.reto3.Controlador;

import com.reto3.reto3.Entidad.Message;
import com.reto3.reto3.Servicio.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/Message/")
public class MessageController {

    @Autowired
    private MessageService service;

    @GetMapping("/all")
    public List<Message> getMessages(){
        return service.getMessages();
    }

    @PostMapping("/save")
    public ResponseEntity saveMessage(@RequestBody Message message){
        service.saveMessage(message);
        return ResponseEntity.status(201).build();
    }
}
