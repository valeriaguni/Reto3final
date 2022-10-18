package com.reto3.reto3.Controlador;

import com.reto3.reto3.Entidad.Client;
import com.reto3.reto3.Servicio.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteClient(@PathVariable int id){
        return service.deleteClient(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client updateClient(@RequestBody Client client){
        return service.updateClient(client);
    }
    }

