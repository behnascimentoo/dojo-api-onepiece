package com.dojo.api_onepiece.controller;

import com.dojo.api_onepiece.dto.CreateMissionDto;
import com.dojo.api_onepiece.dto.MissionResponseDto;
import com.dojo.api_onepiece.dto.UpdateMissionDto;
import com.dojo.api_onepiece.entity.DangerLevel;
import com.dojo.api_onepiece.entity.StatusMission;
import com.dojo.api_onepiece.service.MissionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/mission")
//http://localhost:8080/mission
public class MissionController {

    private final MissionService missionService;

    //Criar Missão
    @PostMapping
    public ResponseEntity<Void> createMission(@Valid @RequestBody CreateMissionDto createMissionDto) {
        missionService.saveMission(createMissionDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //Atualizar Missão
    @PutMapping("/id/{id}")
    public ResponseEntity<MissionResponseDto> updateMisson(@PathVariable Long id,@Valid @RequestBody UpdateMissionDto updateMissionDto){
        MissionResponseDto updateMission = missionService.updateMission(id,updateMissionDto);
        return ResponseEntity.ok(updateMission);
    }

    //Buscar Missão por id
    @GetMapping("/id/{id}")
    public ResponseEntity<MissionResponseDto> searchById(@PathVariable Long id){
        MissionResponseDto mission = missionService.getMissionById(id);
        return ResponseEntity.ok(mission);
    }

    //Listar todas as Missões
    @GetMapping()
    public ResponseEntity<List<MissionResponseDto>> listMissions(
            @RequestParam(required = false) StatusMission statusMission,
            @RequestParam(required = false) DangerLevel dangerLevel)
    {
        List<MissionResponseDto> missions = null;

        if(dangerLevel != null) {
            missions = missionService.listAllDangerLevel(dangerLevel);
        }
        if(statusMission != null){
            missions = missionService.listAllStatusMission(statusMission);
        }
        if(dangerLevel == null && statusMission == null){
            missions = missionService.listOfAllMissions();
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(missions);
    }

}
