package com.tienda.skate.repository;

import com.tienda.skate.model.Client;
import com.tienda.skate.model.Reservation;
import com.tienda.skate.model.dto.CountClient;
import com.tienda.skate.repository.interfaces.ReservationRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationRepositoryInterface reservationRepositoryInterface;

    public ReservationRepository() {
    }

    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationsByClients() {
        return reservationRepositoryInterface.countTotalReservationsByClients();
    }

    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date dateOne, Date dateTwo) {
        return reservationRepositoryInterface.findAllByStartDateAfterAndDevolutionDateBefore(dateOne, dateTwo);
    }

    public List<Reservation> findAllByStatus(String status) {
        return reservationRepositoryInterface.findAllByStatus(status);
    }

    public <S extends Reservation> S save(S entity) {
        return reservationRepositoryInterface.save(entity);
    }

    public <S extends Reservation> Iterable<S> saveAll(Iterable<S> entities) {
        return reservationRepositoryInterface.saveAll(entities);
    }

    public Optional<Reservation> findById(Integer integer) {
        return reservationRepositoryInterface.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return reservationRepositoryInterface.existsById(integer);
    }

    public Iterable<Reservation> findAll() {
        return reservationRepositoryInterface.findAll();
    }

    public Iterable<Reservation> findAllById(Iterable<Integer> integers) {
        return reservationRepositoryInterface.findAllById(integers);
    }

    public long count() {
        return reservationRepositoryInterface.count();
    }

    public void deleteById(Integer integer) {
        reservationRepositoryInterface.deleteById(integer);
    }

    public void delete(Reservation entity) {
        reservationRepositoryInterface.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Integer> integers) {
        reservationRepositoryInterface.deleteAllById(integers);
    }

    public void deleteAll(Iterable<? extends Reservation> entities) {
        reservationRepositoryInterface.deleteAll(entities);
    }
    public void deleteAll() {
        reservationRepositoryInterface.deleteAll();
    }

    public List<CountClient> getTopClients(){
        List<CountClient> respuesta = new ArrayList<>();

        List<Object[]> reporte = reservationRepositoryInterface.countTotalReservationsByClients();

        for(int i= 0; i<reporte.size(); i++){
            respuesta.add(new CountClient((Long) reporte.get(i)[1], (Client) reporte.get(i)[0] ));
        }

        return respuesta;
    }
    public List<Reservation> getReservationPeriod(Date a, Date b){
        return reservationRepositoryInterface.findAllByStartDateAfterAndDevolutionDateBefore(a, b);
    }
    public List<Reservation> getReservationsByStatus(String status){
        return reservationRepositoryInterface.findAllByStatus(status);
    }
}
