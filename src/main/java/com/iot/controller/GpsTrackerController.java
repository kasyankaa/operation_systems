package com.iot.controller;

import com.iot.domain.GpsTracker;
import com.iot.service.GpsTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/gps_tracker", produces = MediaType.APPLICATION_JSON_VALUE)
public class GpsTrackerController extends AbstractController<GpsTracker> {

    @Autowired
    public GpsTrackerController(GpsTrackerService gpsTrackerService) {
        super(gpsTrackerService);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<GpsTracker> updateObject(@PathVariable final Integer id,
                                                   @RequestBody final GpsTracker gpsTracker) {
        gpsTracker.setId(id);
        GpsTracker oldGpsTracker = service.updateObject(id, gpsTracker, new GpsTracker());
        return oldGpsTracker == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(oldGpsTracker, HttpStatus.OK);
    }
}