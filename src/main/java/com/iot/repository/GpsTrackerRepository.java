package com.iot.repository;

import com.iot.domain.GpsTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GpsTrackerRepository extends JpaRepository<GpsTracker, Integer> {
}
