package com.reto3.reto3.Servicio;

import com.reto3.reto3.Entidad.Reservation;
import com.reto3.reto3.Repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    public List<Reservation> getReservations(){
        return repository.findAll();
    }

    public Reservation saveReservation(Reservation reservation){
        return repository.save(reservation);
    }
}
