package com.iot.service;

import com.iot.domain.Snack;
import com.iot.repository.SnackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnackService extends AbstractService<Snack> {
    @Autowired
    public SnackService(SnackRepository repository) {
        super(repository);
    }
}
