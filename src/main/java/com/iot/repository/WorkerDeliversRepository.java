package com.iot.repository;

import com.iot.domain.WorkerDelivers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerDeliversRepository extends JpaRepository<WorkerDelivers, Integer> {
}
