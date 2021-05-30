package com.iot.service;

import com.iot.domain.GpsTracker;
import com.iot.repository.GpsTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GpsTrackerService extends AbstractService<GpsTracker> {
    @Autowired
    public GpsTrackerService(GpsTrackerRepository repository) {
        super(repository);
    }
}
