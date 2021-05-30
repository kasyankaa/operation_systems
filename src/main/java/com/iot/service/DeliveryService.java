package com.iot.service;

import com.iot.domain.Delivery;
import com.iot.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService extends AbstractService<Delivery> {
    @Autowired
    public DeliveryService(DeliveryRepository repository) {
        super(repository);
    }
}
