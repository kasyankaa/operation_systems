package com.iot.service;

import com.iot.domain.UpdatingAutomatWithCoins;
import com.iot.repository.UpdatingAutomatWithCoinsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatingAutomatWithCoinsService extends AbstractService<UpdatingAutomatWithCoins> {
    @Autowired
    public UpdatingAutomatWithCoinsService(UpdatingAutomatWithCoinsRepository repository) {
        super(repository);
    }
}
