package com.dojo.api_onepiece.repository;

import com.dojo.api_onepiece.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
