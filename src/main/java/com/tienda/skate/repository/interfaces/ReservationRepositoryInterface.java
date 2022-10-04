package com.tienda.skate.repository.interfaces;

import com.tienda.skate.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepositoryInterface extends CrudRepository<Reservation, Integer> {
    
}
