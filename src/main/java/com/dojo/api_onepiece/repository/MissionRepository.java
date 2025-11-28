package com.dojo.api_onepiece.repository;

import com.dojo.api_onepiece.entity.DangerLevel;
import com.dojo.api_onepiece.entity.Mission;
import com.dojo.api_onepiece.entity.StatusMission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Optional<Mission> findByDangerLevel(DangerLevel dangerLevel);
    Optional<Mission> findByStatusMission(StatusMission statusMission);
}
