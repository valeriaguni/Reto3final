package com.reto3.reto3.Controlador;

import com.reto3.reto3.Entidad.DTOs.CountClient;
import com.reto3.reto3.Entidad.DTOs.CountStatus;
import com.reto3.reto3.Entidad.Reservation;
import com.reto3.reto3.Entidad.Reservation;
import com.reto3.reto3.Servicio.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/Reservation/")
public class ReservationController {

    @Autowired
    private ReservationService service;

    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return service.getReservations();
    }

    @PostMapping("/save")
    public ResponseEntity saveReservation(@RequestBody Reservation reservation){
        service.saveReservation(reservation);
        return ResponseEntity.status(201).build();
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable int id){
        return service.deleteReservation(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation updateReservation(@RequestBody Reservation Reservation){
        return service.updateReservation(Reservation);
    }

    @GetMapping("/report-status")
    public CountStatus getReservationDescriptionAmount() {
        return service.getReservationByStatus();
    }

    @GetMapping("/report-clients")
    public List<CountClient> getCountClient() {
        return service.getTopClients();
    }
    @GetMapping("report-dates/{startDate}/{devolutionDate}")
    public List<Reservation> getReservationReport(@PathVariable("startDate") String startDateString, @PathVariable("devolutionDate") String devolutionDateString) {
        return service.getReservationPeriod(startDateString, devolutionDateString);
    }
}
