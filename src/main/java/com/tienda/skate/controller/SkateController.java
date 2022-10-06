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
@RequestMapping("/api/Skate")
@CrossOrigin(origins = "*")
public class SkateController {

    @Autowired
    private SkateService service;

    @GetMapping("/all")
    public List<Skate> list() {
        return service.listAll();
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Skate> list2() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skate> get(@PathVariable Integer id) {
        try {
            Skate skate = service.get(id);
            return new ResponseEntity<Skate>(skate, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Skate>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate add(@RequestBody Skate skate) {
        return service.save(skate);
    }

    public SkateController() {
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Skate skate, @PathVariable Integer id) {
        try {
            Skate existSkate = service.get(id);//deberia ser un optional
            service.save(skate);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public Skate update(@RequestBody Skate skate) {
        return service.update(skate);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return service.delete(id);
    }
}
