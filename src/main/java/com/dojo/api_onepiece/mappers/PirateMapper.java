package com.dojo.api_onepiece.mappers;

import com.dojo.api_onepiece.dto.CreatePirateDto;
import com.dojo.api_onepiece.dto.ToPirateResponseDto;
import com.dojo.api_onepiece.dto.UpdatePirateDto;
import com.dojo.api_onepiece.entity.Pirate;
import org.springframework.stereotype.Component;

@Component
public class PirateMapper {

    public Pirate toEntity (CreatePirateDto dto) { // transforma o DTO em uma Entity
        Pirate pirate = new Pirate();
        pirate.setName(dto.name());
        pirate.setRace(dto.race());
        pirate.setCrewPirate(dto.crew());
        return pirate;
    }

    public ToPirateResponseDto toDto(Pirate pirate){
        return new ToPirateResponseDto(
                pirate.getId(),
                pirate.getName(),
                pirate.getRace(),
                pirate.getCrewPirate(),
                pirate.getStatus()
        );
    }

    public void updateEntity(Pirate pirate, UpdatePirateDto dto){
        pirate.setName(dto.name());
        pirate.setRace(dto.racePirate());
        pirate.setCrewPirate(dto.crewPirate());
        pirate.setStatus(dto.statusPirate());
    }
}
