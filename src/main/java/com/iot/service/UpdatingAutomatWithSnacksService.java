package com.iot.service;

import com.iot.domain.UpdatingAutomatWithSnacks;
import com.iot.repository.UpdatingAutomatWithSnacksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatingAutomatWithSnacksService extends AbstractService<UpdatingAutomatWithSnacks> {
    @Autowired
    public UpdatingAutomatWithSnacksService(UpdatingAutomatWithSnacksRepository repository) {
        super(repository);
    }
}
