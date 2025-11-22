package com.dojo.api_onepiece.service;

import com.dojo.api_onepiece.dto.CreatePirateDto;
import com.dojo.api_onepiece.dto.ToPirateResponseDto;
import com.dojo.api_onepiece.dto.UpdatePirateDto;
import com.dojo.api_onepiece.entity.Pirate;
import com.dojo.api_onepiece.entity.RacePirate;
import com.dojo.api_onepiece.exceptions.PirateNotFoundException;
import com.dojo.api_onepiece.mappers.PirateMapper;
import com.dojo.api_onepiece.repository.PirateRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class PirateServiceImp implements PirateService{

    private PirateRepository pirateRepository;
    private PirateMapper pirateMapper;

    @Override
    public void savePirate(CreatePirateDto createPirateDto) {
        Pirate pirate = pirateMapper.toEntity(createPirateDto);
        pirateRepository.save(pirate);
    }

    @Override
    public ToPirateResponseDto updatePirate(Long id, UpdatePirateDto dto) {
        Pirate pirate = pirateRepository.findById(id)
                .orElseThrow(() -> PirateNotFoundException.byId(id));
        pirateMapper.updateEntity(pirate, dto);
        pirateRepository.save(pirate);
        return pirateMapper.toDto(pirate);
    }

    @Override
    public ToPirateResponseDto getPirateById(Long id) {
        return pirateRepository.findById(id)
                .map(pirateMapper::toDto)
                .orElseThrow(() -> PirateNotFoundException.byId(id));
    }

    @Override
    public ToPirateResponseDto getPirateByRace(RacePirate racePirate) {
        return pirateRepository.findByRace(racePirate)
                .map(pirateMapper::toDto)
                .orElseThrow(() -> PirateNotFoundException.byRace(racePirate));
    }

    @Override
    public List<ToPirateResponseDto> listOfAllPirates() {
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
