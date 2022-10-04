package com.tienda.skate.controller;

import com.tienda.skate.model.Skate;
import com.tienda.skate.services.SkateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/Skateboard")
public class SkateController {

    @Autowired
    private SkateService service;

    @GetMapping("/all")
    public List<Skate> list() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skate> get(@PathVariable Integer id) {
        try {
            Skate reservation = service.get(id);
            return new ResponseEntity<Skate>(reservation, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Skate>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public Skate add(@RequestBody Skate reservation) {
        return service.save(reservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Skate reservation, @PathVariable Integer id) {
        try {
            Skate existSkate = service.get(id);
            service.save(reservation);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
