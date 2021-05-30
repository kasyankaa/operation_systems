package com.iot.controller;

import com.iot.service.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractController<E> {
    protected final Service<E> service;

    public AbstractController(Service<E> service) {
        this.service = service;
    }

    @GetMapping
    public List<E> getAllObjects() {
        return service.getAllObjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<E> getObject(@PathVariable final Integer id) {
        E foundObject = service.getObjectById(id);
        return foundObject == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(foundObject, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public E createObject(@RequestBody final E object) {
        return service.createObject(object);
    }

    @PutMapping("/{id}")
    public abstract ResponseEntity<E> updateObject(@PathVariable final Integer id,
                                                   @RequestBody final E city);

    @DeleteMapping("/{id}")
    public ResponseEntity<E> deleteObject(@PathVariable final Integer id) {
        HttpStatus status = service.deleteObject(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(status);
    }
}
