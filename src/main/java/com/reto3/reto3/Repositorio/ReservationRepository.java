package com.reto3.reto3.Repositorio;

import com.reto3.reto3.Entidad.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
