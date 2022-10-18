package com.reto3.reto3.Servicio;

import com.reto3.reto3.Entidad.DTOs.CountClient;
import com.reto3.reto3.Entidad.DTOs.CountStatus;
import com.reto3.reto3.Entidad.Reservation;
import com.reto3.reto3.Entidad.Reservation;
import com.reto3.reto3.Repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Reservation updateReservation(Reservation reservation) {



        if (reservation.getIdReservation() != null) {
            Optional<Reservation> reservationU = repository.findById(reservation.getIdReservation());



            if (!reservationU.isEmpty()) {



                for (Field f : reservation.getClass().getDeclaredFields()) {
                    f.setAccessible(true);
                    Object value;
                    try {
                        value = f.get(reservation);
                        if (value != null) {
                            System.out.println("entro");
                            f.set(reservationU.get(), value);
                        }
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            return repository.save(reservationU.get());
        }
        return reservation;
    }

    public boolean deleteReservation(int id) {
        Optional<Reservation> reservationd = repository.findById(id);
        if (reservationd.isEmpty()) {
            return false;
        } else {
            repository.delete(reservationd.get());
            return true;
        }
    }

    //Reto 5
    public List<CountClient> getTopClients(){
        return repository.getTopClients();
    }

    public List<Reservation> getReservationPeriod(String dateA, String dateB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd"); //2022-06-21
        Date a = new Date();
        Date b = new Date();
        try {
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        } catch (ParseException exception) {
            exception.printStackTrace();
        }
        if (a.before(b)) {
            return repository.getReservationPeriod(a, b);
        } else {
            return new ArrayList<>();
        }

    }
    public CountStatus getReservationByStatus(){
        List<Reservation> completed = repository.getReservationByStatus("completed");

        List<Reservation> cancelled = repository.getReservationByStatus("cancelled");

        return new CountStatus(completed.size(), cancelled.size());
    }
}
