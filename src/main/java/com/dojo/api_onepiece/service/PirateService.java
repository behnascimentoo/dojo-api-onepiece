package com.dojo.api_onepiece.service;

import com.dojo.api_onepiece.dto.CreatePirateDto;
import com.dojo.api_onepiece.dto.PirateResponseDto;
import com.dojo.api_onepiece.dto.UpdatePirateDto;
import com.dojo.api_onepiece.entity.RacePirate;

import java.util.List;

public interface PirateService {

    void savePirate(CreatePirateDto createPirateDto);

    PirateResponseDto updatePirate(Long id, UpdatePirateDto dto);

    PirateResponseDto getPirateById(Long id);

    PirateResponseDto getPirateByRace(RacePirate racePirate);

    List<PirateResponseDto> listOfAllPirates();

    void deletePirate(Long id);

}
