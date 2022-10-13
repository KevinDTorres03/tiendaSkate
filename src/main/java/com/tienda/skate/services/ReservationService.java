package com.tienda.skate.services;

import com.tienda.skate.model.Reservation;
import com.tienda.skate.model.dto.CountClient;
import com.tienda.skate.model.dto.CountStatus;
import com.tienda.skate.repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public ReservationService() {
    }

    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationsByClients() {
        return reservationRepository.countTotalReservationsByClients();
    }

    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date dateOne, Date dateTwo) {
        return reservationRepository.findAllByStartDateAfterAndDevolutionDateBefore(dateOne, dateTwo);
    }

    public List<Reservation> findAllByStatus(String status) {
        return reservationRepository.findAllByStatus(status);
    }

    public <S extends Reservation> S save(S entity) {
        return reservationRepository.save(entity);
    }

    public <S extends Reservation> Iterable<S> saveAll(Iterable<S> entities) {
        return reservationRepository.saveAll(entities);
    }

    public void deleteAllById(Iterable<? extends Integer> integers) {
        reservationRepository.deleteAllById(integers);
    }

    public void deleteAll(Iterable<? extends Reservation> entities) {
        reservationRepository.deleteAll(entities);
    }

    public void deleteAll() {
        reservationRepository.deleteAll();
    }

    public List<Reservation> getReservationPeriod(Date a, Date b) {
        return reservationRepository.getReservationPeriod(a, b);
    }

    public List<Reservation> getReservationsByStatus(String status) {
        return reservationRepository.getReservationsByStatus(status);
    }

    public Optional<Reservation> findById(Integer integer) {
        return reservationRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return reservationRepository.existsById(integer);
    }

    public Iterable<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Iterable<Reservation> findAllById(Iterable<Integer> integers) {
        return reservationRepository.findAllById(integers);
    }

    public long count() {
        return reservationRepository.count();
    }

    public void deleteById(Integer integer) {
        reservationRepository.deleteById(integer);
    }

    public void delete(Reservation entity) {
        reservationRepository.delete(entity);
    }

    public List<CountClient> getTopClients(){
        return reservationRepository.getTopClients();
    }

    public List<Reservation> getReservationPeriod(String dateA, String dateB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try {
            a = parser.parse(dateA);
            b = parser.parse (dateB);

        }catch (ParseException excepcion){
            excepcion.printStackTrace();
        }
        if (a.before(b)){
            return reservationRepository.getReservationPeriod(a, b);
        }else{
            return new ArrayList<>();
        }
    }

    public CountStatus getReservationsStatus(){
        List<Reservation> completed = reservationRepository.getReservationsByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationsByStatus("cancelled");

        return new CountStatus((long) completed.size(), (long) cancelled.size());
    }
}