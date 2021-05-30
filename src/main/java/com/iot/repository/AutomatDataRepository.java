package com.iot.repository;

import com.iot.domain.AutomatData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomatDataRepository extends JpaRepository<AutomatData, Integer> {
}
