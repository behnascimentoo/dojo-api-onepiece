package com.dojo.api_onepiece.repository;

import com.dojo.api_onepiece.entity.Pirate;
import com.dojo.api_onepiece.entity.RacePirate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PirateRepository extends JpaRepository<Pirate, Long> {
    Optional<RacePirate> findByRace(RacePirate racePirate);
}
