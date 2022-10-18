package com.reto3.reto3.Repositorio;

import com.reto3.reto3.Entidad.DTOs.CountClient;
import com.reto3.reto3.Entidad.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationByClient();

    // SELECT * FROM Reservation WHERE startDate AFTER dateOne AND devolutionDate BEFORE dateTwo:
    public  List<Reservation> findAllByStartDateAfterAndDevolutionDateIsBefore(Date dateOne, Date dateTwo);

    //SELECT * FROM Reservation WHERE status = 'cancelled'
    public List<Reservation> findAllByStatus(String status);

    List<Reservation> getReservationPeriod(Date a, Date b);

    List<Reservation> getReservationByStatus(String completed);

    List<CountClient> getTopClients();
}

