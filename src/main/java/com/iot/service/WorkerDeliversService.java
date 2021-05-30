package com.iot.service;

import com.iot.domain.WorkerDelivers;
import com.iot.repository.WorkerDeliversRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerDeliversService extends AbstractService<WorkerDelivers> {

    @Autowired
    public WorkerDeliversService(WorkerDeliversRepository repository) {
        super(repository);
    }
}
