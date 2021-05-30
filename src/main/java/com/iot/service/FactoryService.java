package com.iot.service;

import com.iot.domain.Factory;
import com.iot.repository.FactoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactoryService extends AbstractService<Factory> {
    @Autowired
    public FactoryService(FactoryRepository repository) {
        super(repository);
    }
}
