package com.tienda.skate.controller;

import com.tienda.skate.model.Category;
import com.tienda.skate.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/all")
    public List<Category> list() {
        return service.listAll();
    }

    public CategoryController() {
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Category> list2() {
        return service.listAll();
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Category> list2() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> get(@PathVariable Integer id) {
        try {
            Category category = service.get(id).get();
            return new ResponseEntity<Category>(category, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category add(@RequestBody Category category) {
        return service.save(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Category category, @PathVariable Integer id) {
        try {
            Category existCategory = service.get(id).get();
            service.save(category);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update")
    public Category update(@RequestBody Category category) {
        return service.update(category);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return service.delete(id);
    }

}
