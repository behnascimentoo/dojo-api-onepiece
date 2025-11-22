package com.dojo.api_onepiece.repository;

import com.dojo.api_onepiece.dto.CreateMissionDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<CreateMissionDto, Long> {
}
