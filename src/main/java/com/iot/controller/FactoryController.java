package com.iot.controller;

import com.iot.domain.Factory;
import com.iot.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/factory", produces = MediaType.APPLICATION_JSON_VALUE)
public class FactoryController extends AbstractController<Factory> {

    @Autowired
    public FactoryController(FactoryService factoryService) {
        super(factoryService);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Factory> updateObject(@PathVariable final Integer id,
                                                @RequestBody final Factory factory) {
        factory.setId(id);
        Factory oldFactory = service.updateObject(id, factory, new Factory());
        return oldFactory == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(oldFactory, HttpStatus.OK);
    }
}