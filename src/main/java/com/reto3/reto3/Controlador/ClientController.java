package com.reto3.reto3.Controlador;

import com.reto3.reto3.Entidad.Client;
import com.reto3.reto3.Servicio.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*")
public class ClientController {
    @Autowired
    private ClientService service;

    @GetMapping("/all")
    public List<Client> getClients(){
        return service.getClients();
    }

    @PostMapping("/save")
    public ResponseEntity saveClient (@RequestBody Client client) {
        service.saveClient(client);
        return ResponseEntity.status(201).build();
    }
    /* @PutMapping("/update")
    public ResponseEntity updateCategory(@RequestBody Category category){
        service.updateCategory(category);
        return ResponseEntity.status(201).build();
    }*/

        @DeleteMapping("/{id}")
        public ResponseEntity deleteClient(@PathVariable long id){
            service.deleteClient(id);
            return ResponseEntity.status(204).build();
        }
    }

