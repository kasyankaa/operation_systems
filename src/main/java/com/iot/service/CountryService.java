package com.iot.service;

import com.iot.domain.Country;
import com.iot.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends AbstractService<Country> {
    @Autowired
    public CountryService(CountryRepository repository) {
        super(repository);
    }
}
