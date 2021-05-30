package com.iot.controller;

import com.iot.domain.Snack;
import com.iot.service.SnackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/snack", produces = MediaType.APPLICATION_JSON_VALUE)
public class SnackController extends AbstractController<Snack> {

    @Autowired
    public SnackController(SnackService snackService) {
        super(snackService);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Snack> updateObject(@PathVariable final Integer id,
                                              @RequestBody final Snack snack) {
        snack.setId(id);
        Snack oldSnack = service.updateObject(id, snack, new Snack());
        return oldSnack == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(oldSnack, HttpStatus.OK);
    }
}
