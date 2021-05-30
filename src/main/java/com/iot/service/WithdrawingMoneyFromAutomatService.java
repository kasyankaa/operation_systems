package com.iot.service;

import com.iot.domain.WithdrawingMoneyFromAutomat;
import com.iot.repository.WithdrawingMoneyFromAutomatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawingMoneyFromAutomatService extends AbstractService<WithdrawingMoneyFromAutomat> {
    @Autowired
    public WithdrawingMoneyFromAutomatService(WithdrawingMoneyFromAutomatRepository repository) {
        super(repository);
    }
}
