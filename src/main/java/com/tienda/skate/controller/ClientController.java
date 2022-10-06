package com.tienda.skate.controller;

import com.tienda.skate.model.Client;
import com.tienda.skate.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/all")
    public List<Client> list() {
        return service.listAll();
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Client> list2() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> get(@PathVariable Integer id) {
        try {
            Client client = service.get(id).get();
            return new ResponseEntity<Client>(client, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client add(@RequestBody Client client) {
        return service.save(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Client client, @PathVariable Integer id) {
        try {
            Client existClient = service.get(id).get();
            service.save(client);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update")
    public Client update(@RequestBody Client client) {
        return service.Update(client);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return service.delete(id);
    }

}
