package com.tienda.skate.controller;

import com.tienda.skate.model.Admin;
import com.tienda.skate.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService service;

    public AdminController() {
    }

    @GetMapping("/all")
    public List<Admin> list() {
        return service.listAll();
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Admin> list2() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> get(@PathVariable Integer id) {
        try {
            Admin admin = service.get(id).get();
            return new ResponseEntity<Admin>(admin, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin add(@RequestBody Admin admin) {
        return service.save(admin);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin admin) {
        return service.Update(admin);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable Integer id) {
        return service.delete(id);
    }

}
