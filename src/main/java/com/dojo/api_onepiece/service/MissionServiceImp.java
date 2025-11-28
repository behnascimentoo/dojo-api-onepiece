package com.dojo.api_onepiece.service;

import com.dojo.api_onepiece.dto.CreateMissionDto;
import com.dojo.api_onepiece.dto.MissionResponseDto;
import com.dojo.api_onepiece.dto.UpdateMissionDto;
import com.dojo.api_onepiece.entity.DangerLevel;
import com.dojo.api_onepiece.entity.Mission;
import com.dojo.api_onepiece.entity.StatusMission;
import com.dojo.api_onepiece.exceptions.MissionNotFoundException;
import com.dojo.api_onepiece.mappers.MissionMapper;
import com.dojo.api_onepiece.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissionServiceImp implements MissionService{

    private MissionRepository missionRepository;
    private MissionMapper missionMapper;

    @Override
    public void saveMission(CreateMissionDto createMissionDto) {
        Mission mission = missionMapper.toEntity(createMissionDto);
        missionRepository.save(mission);
    }

    @Override
    public MissionResponseDto updateMission(Long id, UpdateMissionDto dto) {
        Mission mission = missionRepository.findById(id)
                .orElseThrow(()-> MissionNotFoundException.byId(id));
        missionMapper.updateEntity(mission, dto);
        missionRepository.save(mission);
        return missionMapper.toDto(mission);
    }

    @Override
    public MissionResponseDto getMissionById(Long id) {
        return missionRepository.findById(id)
                .map(missionMapper::toDto)
                .orElseThrow(()-> MissionNotFoundException.byId(id));
    }


    @Override
    public List<MissionResponseDto> listOfAllMissions() {
        return missionRepository.findAll()
                .stream()
                .map(missionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MissionResponseDto> listAllDangerLevel(DangerLevel dangerLevel) {
        return missionRepository.findByDangerLevel(dangerLevel)
                .stream()
                .map(missionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MissionResponseDto> listAllStatusMission(StatusMission statusMission){
        return missionRepository.findByStatusMission(statusMission)
                .stream()
                .map(missionMapper::toDto)
                .collect(Collectors.toList());
    }
}
