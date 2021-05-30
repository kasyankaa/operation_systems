package com.iot.controller;

import com.iot.domain.WorkerDelivers;
import com.iot.service.WorkerDeliversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/worker_delivers", produces = MediaType.APPLICATION_JSON_VALUE)
public class WorkerDeliversController extends AbstractController<WorkerDelivers> {

    @Autowired
    public WorkerDeliversController(WorkerDeliversService workerDeliversService) {
        super(workerDeliversService);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<WorkerDelivers> updateObject(@PathVariable final Integer id,
                                                       @RequestBody final WorkerDelivers workerDelivers) {
        workerDelivers.setId(id);
        WorkerDelivers oldWorkerDelivers = service.updateObject(id, workerDelivers, new WorkerDelivers());
        return oldWorkerDelivers == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(oldWorkerDelivers, HttpStatus.OK);
    }
}
