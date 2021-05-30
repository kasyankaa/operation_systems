package com.iot.repository;

import com.iot.domain.UpdatingAutomatWithCoins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdatingAutomatWithCoinsRepository extends JpaRepository<UpdatingAutomatWithCoins, Integer> {
}
