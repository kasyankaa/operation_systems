package com.iot.service;

import com.iot.domain.Region;
import com.iot.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService extends AbstractService<Region> {
    @Autowired
    public RegionService(RegionRepository repository) {
        super(repository);
    }
}
