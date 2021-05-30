package com.iot.service;

import com.iot.domain.AutomatData;
import com.iot.repository.AutomatDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutomatDataService extends AbstractService<AutomatData> {
    @Autowired
    public AutomatDataService(AutomatDataRepository repository) {
        super(repository);
    }
}
