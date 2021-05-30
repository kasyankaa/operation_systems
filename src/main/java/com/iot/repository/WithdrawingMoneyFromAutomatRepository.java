package com.iot.repository;

import com.iot.domain.WithdrawingMoneyFromAutomat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawingMoneyFromAutomatRepository extends JpaRepository<WithdrawingMoneyFromAutomat, Integer> {
}
