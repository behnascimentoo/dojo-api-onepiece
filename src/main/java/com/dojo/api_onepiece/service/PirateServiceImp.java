package com.dojo.api_onepiece.service;

import com.dojo.api_onepiece.dto.CreatePirateDto;
import com.dojo.api_onepiece.dto.PirateResponseDto;
import com.dojo.api_onepiece.dto.UpdatePirateDto;
import com.dojo.api_onepiece.entity.Pirate;
import com.dojo.api_onepiece.entity.RacePirate;
import com.dojo.api_onepiece.exceptions.PirateNotFoundException;
import com.dojo.api_onepiece.exceptions.RaceNotFoundException;
import com.dojo.api_onepiece.mappers.PirateMapper;
import com.dojo.api_onepiece.repository.PirateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PirateServiceImp implements PirateService{

    private final PirateRepository pirateRepository;
    private final PirateMapper pirateMapper;

    @Override
    public void savePirate(CreatePirateDto createPirateDto) {
        Pirate pirate = pirateMapper.toEntity(createPirateDto);
        pirateRepository.save(pirate);
    }

    @Override
    public PirateResponseDto updatePirate(Long id, UpdatePirateDto dto) {
        Pirate pirate = pirateRepository.findById(id)
                .orElseThrow(() -> PirateNotFoundException.byId(id));
        pirateMapper.updateEntity(pirate, dto);
        pirateRepository.save(pirate);
        return pirateMapper.toDto(pirate);
    }

    @Override
    public PirateResponseDto getPirateById(Long id) {
        return pirateRepository.findById(id)
                .map(pirateMapper::toDto)
                .orElseThrow(() -> PirateNotFoundException.byId(id));
    }

    @Override
    public List<PirateResponseDto> findPiratesByRace(RacePirate racePirate) {
        var pirates = pirateRepository.findByRace(racePirate)
                .orElseThrow(() -> RaceNotFoundException.byRace(racePirate));
        return pirates
                .stream()
                .map(pirateMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public List<PirateResponseDto> listOfAllPirates() {
        return pirateRepository.findAll()
                .stream()
                .map(pirateMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePirate(Long id) {
        if(!pirateRepository.existsById(id)){
            throw PirateNotFoundException.byId(id);
        }
        pirateRepository.deleteById(id);
    }
}
