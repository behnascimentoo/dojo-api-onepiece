package com.dojo.api_onepiece.mappers;

import com.dojo.api_onepiece.dto.CreateMissionDto;
import com.dojo.api_onepiece.dto.MissionResponseDto;
import com.dojo.api_onepiece.dto.UpdateMissionDto;
import com.dojo.api_onepiece.entity.Mission;
import org.springframework.stereotype.Component;

@Component
public class MissionMapper {

    public Mission toEntity(CreateMissionDto dto){
        Mission mission = new Mission();
        mission.setTypeMission(dto.typeOfMission());
        mission.setDangerLevel(dto.dangerLevel());
        mission.setStatusMission(dto.statusMission());
        return mission;
    }

    public MissionResponseDto toDto(Mission mission){
        return new MissionResponseDto(
                        mission.getId(),
                mission.getDangerLevel(),
                mission.getTypeMission(),
                        mission.getStatusMission()
                        );
    }

    public void updateEntity(Mission mission, UpdateMissionDto dto){
        mission.setTypeMission(dto.typeOfMission());
        mission.setDangerLevel(dto.dangerLevel());
        mission.setStatusMission(dto.statusMission());
    }
}
