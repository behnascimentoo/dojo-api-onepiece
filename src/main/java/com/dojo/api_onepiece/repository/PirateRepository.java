package com.dojo.api_onepiece.repository;

import com.dojo.api_onepiece.dto.CreatePirateDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PirateRepository extends JpaRepository<CreatePirateDto, Long> {
}
