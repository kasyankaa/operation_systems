package com.iot.controller;

import com.iot.domain.UpdatingAutomatWithCoins;
import com.iot.service.UpdatingAutomatWithCoinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/updating_automat_with_coins", produces = MediaType.APPLICATION_JSON_VALUE)
public class UpdatingAutomatWithCoinsController extends AbstractController<UpdatingAutomatWithCoins> {

    @Autowired
    public UpdatingAutomatWithCoinsController(UpdatingAutomatWithCoinsService updatingAutomatWithCoinsService) {
        super(updatingAutomatWithCoinsService);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<UpdatingAutomatWithCoins> updateObject(@PathVariable final Integer id,
                                                                 @RequestBody final UpdatingAutomatWithCoins updatingAutomatWithCoins) {
        updatingAutomatWithCoins.setId(id);
        UpdatingAutomatWithCoins oldUpdatingAutomatWithCoins = service.updateObject(id, updatingAutomatWithCoins, new UpdatingAutomatWithCoins());
        return oldUpdatingAutomatWithCoins == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(oldUpdatingAutomatWithCoins, HttpStatus.OK);
    }
}
