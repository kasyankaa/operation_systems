package com.iot.controller;

import com.iot.domain.Delivery;
import com.iot.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/delivery", produces = MediaType.APPLICATION_JSON_VALUE)
public class DeliveryController extends AbstractController<Delivery> {

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        super(deliveryService);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Delivery> updateObject(@PathVariable final Integer id,
                                                 @RequestBody final Delivery delivery) {
        delivery.setId(id);
        Delivery oldDelivery = service.updateObject(id, delivery, new Delivery());
        return oldDelivery == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(oldDelivery, HttpStatus.OK);
    }
}