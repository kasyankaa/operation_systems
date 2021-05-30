package com.iot.controller;

import com.iot.domain.WithdrawingMoneyFromAutomat;
import com.iot.service.WithdrawingMoneyFromAutomatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/withdrawing_money_from_automat", produces = MediaType.APPLICATION_JSON_VALUE)
public class WithdrawingMoneyFromAutomatController extends AbstractController<WithdrawingMoneyFromAutomat> {

    @Autowired
    public WithdrawingMoneyFromAutomatController(WithdrawingMoneyFromAutomatService withdrawingMoneyFromAutomatService) {
        super(withdrawingMoneyFromAutomatService);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<WithdrawingMoneyFromAutomat> updateObject(@PathVariable final Integer id,
                                                                    @RequestBody final WithdrawingMoneyFromAutomat withdrawingMoneyFromAutomat) {
        withdrawingMoneyFromAutomat.setId(id);
        WithdrawingMoneyFromAutomat oldWithdrawing = service.updateObject(id, withdrawingMoneyFromAutomat, new WithdrawingMoneyFromAutomat());
        return oldWithdrawing == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(oldWithdrawing, HttpStatus.OK);
    }
}