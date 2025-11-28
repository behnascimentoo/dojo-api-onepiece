package com.dojo.api_onepiece.repository;

import com.dojo.api_onepiece.entity.Pirate;
import com.dojo.api_onepiece.entity.RacePirate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PirateRepository extends JpaRepository<Pirate, Long> {
    Optional<List<Pirate>> findByRace(RacePirate racePirate);
}
