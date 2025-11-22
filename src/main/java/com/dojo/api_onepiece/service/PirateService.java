package com.dojo.api_onepiece.service;

import com.dojo.api_onepiece.dto.CreatePirateDto;
import com.dojo.api_onepiece.dto.ToPirateResponseDto;
import com.dojo.api_onepiece.dto.UpdatePirateDto;
import com.dojo.api_onepiece.entity.RacePirate;

import java.util.List;

public interface PirateService {

    void savePirate(CreatePirateDto createPirateDto);

    ToPirateResponseDto updatePirate(Long id, UpdatePirateDto dto);

    ToPirateResponseDto getPirateById(Long id);

    ToPirateResponseDto getPirateByRace(RacePirate racePirate);

    List<ToPirateResponseDto> listOfAllPirates();

    void deletePirate(Long id);

}
