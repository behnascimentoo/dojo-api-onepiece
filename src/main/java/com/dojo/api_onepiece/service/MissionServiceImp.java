package com.dojo.api_onepiece.service;

import com.dojo.api_onepiece.dto.CreateMissionDto;
import com.dojo.api_onepiece.dto.ToMissionResponseDto;
import com.dojo.api_onepiece.dto.UpdateMissionDto;
import com.dojo.api_onepiece.entity.Mission;
import com.dojo.api_onepiece.exceptions.MissionNotFoundException;
import com.dojo.api_onepiece.mappers.MissionMapper;
import com.dojo.api_onepiece.repository.MissionRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class MissionServiceImp implements MissionService{

    private MissionRepository missionRepository;
    private MissionMapper missionMapper;

    @Override
    public void saveMission(CreateMissionDto createMissionDto) {
        Mission mission = missionMapper.toEntity(createMissionDto);
        missionRepository.save(mission);
    }

    @Override
    public ToMissionResponseDto updateMission(Long id, UpdateMissionDto dto) {
        Mission mission = missionRepository.findBy(id)
                .orElseThrow(()-> MissionNotFoundException.byId(id));
        missionMapper.updateEntity(mission, dto);
        missionRepository.save(mission);
        return missionMapper.toDto(mission);
    }

    @Override
    public ToMissionResponseDto getMissionById(Long id) {
        return missionRepository.findBy(id)
                .map(missionMapper::toDto)
                .orElseThrow(()-> MissionNotFoundException.byId(id));
    }

    @Override
    public List<ToMissionResponseDto> listOfAllMissions() {
        return missionRepository.findAll()
                .stream()
                .map(missionMapper::toDto)
                .collect(Collectors.toList());
    }
}
