package com.iot.repository;

import com.iot.domain.SnackAutomat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnackAutomatRepository extends JpaRepository<SnackAutomat, Integer> {
}
