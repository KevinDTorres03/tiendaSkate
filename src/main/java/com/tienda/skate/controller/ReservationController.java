package com.tienda.skate.controller;

import com.tienda.skate.model.Reservation;
import com.tienda.skate.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*")
public class ReservationController {

    @Autowired
    private ReservationService service;

    @GetMapping("/all")
    public List<Reservation> list() {
        return service.listAll();
    }
    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Reservation> list2() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> get(@PathVariable Integer id) {
        try {
            Reservation reservation = service.get(id).get();
            return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation add(@RequestBody Reservation reservation) {
        return service.save(reservation);
    }

    @PutMapping("/update")
    public Reservation update(@RequestBody Reservation reservation) {
        return service.Update(reservation);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    public ReservationController() {
    }
}
