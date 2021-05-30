package com.iot.controller;

import com.iot.domain.UpdatingAutomatWithSnacks;
import com.iot.service.UpdatingAutomatWithSnacksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/updating_automat_with_snacks", produces = MediaType.APPLICATION_JSON_VALUE)
public class UpdatingAutomatWithSnacksController extends AbstractController<UpdatingAutomatWithSnacks> {

    @Autowired
    public UpdatingAutomatWithSnacksController(UpdatingAutomatWithSnacksService updatingAutomatWithSnacksService) {
        super(updatingAutomatWithSnacksService);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<UpdatingAutomatWithSnacks> updateObject(@PathVariable final Integer id,
                                                                  @RequestBody final UpdatingAutomatWithSnacks updatingAutomatWithSnacks) {
        updatingAutomatWithSnacks.setId(id);
        UpdatingAutomatWithSnacks oldUpdatingAutomatWithSnacks = service.updateObject(id, updatingAutomatWithSnacks, new UpdatingAutomatWithSnacks());
        return oldUpdatingAutomatWithSnacks == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(oldUpdatingAutomatWithSnacks, HttpStatus.OK);
    }
}