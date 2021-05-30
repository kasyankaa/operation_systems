package com.iot.controller;

import com.iot.domain.Worker;
import com.iot.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/worker", produces = MediaType.APPLICATION_JSON_VALUE)
public class WorkerController extends AbstractController<Worker> {

    @Autowired
    public WorkerController(WorkerService workerService) {
        super(workerService);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Worker> updateObject(@PathVariable final Integer id,
                                               @RequestBody final Worker worker) {
        worker.setId(id);
        Worker oldWorker = service.updateObject(id, worker, new Worker());
        return oldWorker == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(oldWorker, HttpStatus.OK);
    }
}
