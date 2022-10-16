package com.reto3.reto3.Servicio;

import com.reto3.reto3.Entidad.Admin;
import com.reto3.reto3.Repositorio.AdminRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRespository repository;

    public List<Admin> getAdmins(){
        return repository.findAll();
    }

    public Admin saveAdmin(Admin admin){
        return repository.save(admin);
    }
}
