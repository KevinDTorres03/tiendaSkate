package com.tienda.skate.repository;

import com.tienda.skate.model.Reservation;
import com.tienda.skate.repository.interfaces.ReservationRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationRepositoryInterface reservationRepositoryInterface;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationRepositoryInterface.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepositoryInterface.findById(id);
    }
    public Reservation save(Reservation reservation){
        return reservationRepositoryInterface.save(reservation);
    }
    public void delete(Reservation reservation){
        reservationRepositoryInterface.delete(reservation);
    }

    public ReservationRepository() {
    }
}
