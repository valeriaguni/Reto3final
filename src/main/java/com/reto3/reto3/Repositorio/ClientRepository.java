package com.reto3.reto3.Repositorio;

import com.reto3.reto3.Entidad.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository  extends JpaRepository<Client, Integer> {
}
