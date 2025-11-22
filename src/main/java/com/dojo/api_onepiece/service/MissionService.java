package com.dojo.api_onepiece.service;

import com.dojo.api_onepiece.dto.CreateMissionDto;
import com.dojo.api_onepiece.dto.ToMissionResponseDto;
import com.dojo.api_onepiece.dto.UpdateMissionDto;

import java.util.List;


public interface MissionService {

    void saveMission(CreateMissionDto createMissionDto);

    ToMissionResponseDto updateMission(Long id, UpdateMissionDto dto);

    ToMissionResponseDto getMissionById(Long id);

    List<ToMissionResponseDto> listOfAllMissions();
}
