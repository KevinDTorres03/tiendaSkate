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
public class MessageController {

    @Autowired
    private MessageService service;

    @GetMapping("/all")
    public List<Message> list() {
        return service.getAll();
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

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
