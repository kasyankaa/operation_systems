package com.iot.service;

import com.iot.domain.SnackAutomat;
import com.iot.repository.SnackAutomatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnackAutomatService extends AbstractService<SnackAutomat> {
    @Autowired
    public SnackAutomatService(SnackAutomatRepository repository) {
        super(repository);
    }
}
