package com.tienda.skate.services;

import com.tienda.skate.model.Reservation;
import com.tienda.skate.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> get(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservacion) {
        if (reservacion.getIdReservation() == 0) {
            return reservationRepository.save(reservacion);
        } else {
            Optional<Reservation> a = reservationRepository.getReservation(reservacion.getIdReservation());
            if (a.isPresent()) {
                return a.get();
            } else {
                return reservationRepository.save(reservacion);
            }
        }
    }

    public Reservation Update(Reservation reservacion) {
        if (reservacion.getIdReservation() != 0) {
            Optional<Reservation> rs = reservationRepository.getReservation(reservacion.getIdReservation());
            if (rs.isPresent()) {
                if (reservacion.getStartDate() != null) {
                    rs.get().setStartDate(reservacion.getStartDate());
                }
                if (reservacion.getDevolutionDate() != null) {
                    rs.get().setDevolutionDate(reservacion.getDevolutionDate());
                }
                if (reservacion.getStatus() != null) {
                    rs.get().setStatus(reservacion.getStatus());
                }
                if (reservacion.getScore() != null) {
                    rs.get().setScore(reservacion.getScore());
                }
                if (reservacion.getSkate() != null) {
                    rs.get().setSkate(reservacion.getSkate());
                }
                if (reservacion.getClient() != null) {
                    rs.get().setClient(reservacion.getClient());
                }

                reservationRepository.save(rs.get());
                return rs.get();

            } else {
                return reservacion;
            }
        } else {
            return reservacion;
        }
    }

    public boolean delete(int id) {
        boolean marca = false;
        Optional<Reservation> a = reservationRepository.getReservation(id);
        if (a.isPresent()) {
            reservationRepository.delete(a.get());
            marca = true;
        }
        return marca;
    }
}