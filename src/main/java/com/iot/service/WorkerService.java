package com.iot.service;

import com.iot.domain.Worker;
import com.iot.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService extends AbstractService<Worker> {
    @Autowired
    public WorkerService(WorkerRepository repository) {
        super(repository);
    }
}
