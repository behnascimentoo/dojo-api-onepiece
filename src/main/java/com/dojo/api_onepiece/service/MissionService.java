package com.dojo.api_onepiece.service;

import com.dojo.api_onepiece.dto.CreateMissionDto;
import com.dojo.api_onepiece.dto.MissionResponseDto;
import com.dojo.api_onepiece.dto.UpdateMissionDto;
import com.dojo.api_onepiece.entity.DangerLevel;
import com.dojo.api_onepiece.entity.StatusMission;

import java.util.List;


public interface MissionService {

    void saveMission(CreateMissionDto createMissionDto);

    MissionResponseDto updateMission(Long id, UpdateMissionDto dto);

    MissionResponseDto getMissionById(Long id);

    List<MissionResponseDto> listOfAllMissions();

    List<MissionResponseDto> listAllDangerLevel(DangerLevel dangerLevel);

    List<MissionResponseDto> listAllStatusMission(StatusMission statusMission);

}
