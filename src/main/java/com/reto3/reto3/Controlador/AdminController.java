package com.reto3.reto3.Controlador;

import com.reto3.reto3.Entidad.Admin;
import com.reto3.reto3.Servicio.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*")
public class AdminController {
    @Autowired
    private AdminService service;

    @GetMapping("/all")
    public List<Admin> getAdmins(){
        return service.getAdmins();
    }

    @PostMapping("/save")
    public ResponseEntity saveAdmin(@RequestBody Admin admin){
        service.saveAdmin(admin);
        return ResponseEntity.status(201).build();
    }
}
