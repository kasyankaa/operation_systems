package com.iot.repository;

import com.iot.domain.UpdatingAutomatWithSnacks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdatingAutomatWithSnacksRepository extends JpaRepository<UpdatingAutomatWithSnacks, Integer> {
}
