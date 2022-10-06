package com.tienda.skate.controller;

import com.tienda.skate.model.Message;
import com.tienda.skate.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*")
public class MessageController {

    @Autowired
    private MessageService service;

    @GetMapping("/all")
    public List<Message> list() {
        return service.listAll();
    }

    public MessageController() {
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Message> list2() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> get(@PathVariable Integer id) {
        try {
            Message message = service.get(id).get();
            return new ResponseEntity<Message>(message, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Message>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message add(@RequestBody Message message) {
        return service.save(message);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Message message, @PathVariable Integer id) {
        try {
            Message existMessage = service.get(id).get();
            service.save(message);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update")
    public Message update(@RequestBody Message message) {
        return service.Update(message);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return service.delete(id);
    }

}
