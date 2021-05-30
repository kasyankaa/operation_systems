package com.iot.controller;

import com.iot.domain.SnackAutomat;
import com.iot.service.SnackAutomatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/snack_automat", produces = MediaType.APPLICATION_JSON_VALUE)
public class SnackAutomatController extends AbstractController<SnackAutomat> {

    @Autowired
    public SnackAutomatController(SnackAutomatService snackAutomatService) {
        super(snackAutomatService);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<SnackAutomat> updateObject(@PathVariable final Integer id,
                                                     @RequestBody final SnackAutomat snackAutomat) {
        snackAutomat.setId(id);
        SnackAutomat oldSnackAutomat = service.updateObject(id, snackAutomat, new SnackAutomat());
        return oldSnackAutomat == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(oldSnackAutomat, HttpStatus.OK);
    }
}
