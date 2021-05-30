package com.iot.controller;

import com.iot.domain.AutomatData;
import com.iot.service.AutomatDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/automat_data", produces = MediaType.APPLICATION_JSON_VALUE)
public class AutomatDataController extends AbstractController<AutomatData> {

    @Autowired
    public AutomatDataController(AutomatDataService automatDataService) {
        super(automatDataService);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<AutomatData> updateObject(@PathVariable final Integer id,
                                                    @RequestBody final AutomatData automatData) {
        automatData.setId(id);
        AutomatData oldAutomatData = service.updateObject(id, automatData, new AutomatData());
        return oldAutomatData == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(oldAutomatData, HttpStatus.OK);
    }
}
