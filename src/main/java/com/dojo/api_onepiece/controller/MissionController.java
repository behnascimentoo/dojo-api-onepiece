package com.dojo.api_onepiece.controller;

import com.dojo.api_onepiece.dto.CreateMissionDto;
import com.dojo.api_onepiece.dto.ToMissionResponseDto;
import com.dojo.api_onepiece.dto.UpdateMissionDto;
import com.dojo.api_onepiece.service.MissionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("mission")
public class MissionController {

    private final MissionService missionService;

    //Criar Missão
    @PostMapping
    public ResponseEntity<Void> createMission(@RequestBody CreateMissionDto createMissionDto) {
        missionService.saveMission(createMissionDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //Atualizar Missão
    @PutMapping("/{id}")
    public ResponseEntity<ToMissionResponseDto> updateMisson(@PathVariable Long id,@RequestBody UpdateMissionDto updateMissionDto){
        ToMissionResponseDto updateMission = missionService.updateMission(id,updateMissionDto);
        return ResponseEntity.ok(updateMission);
    }

    //Buscar Missão por id
    @GetMapping("/{id}")
    public ResponseEntity<ToMissionResponseDto> searchById(@PathVariable Long id){
        ToMissionResponseDto mission = missionService.getMissionById(id);
        return ResponseEntity.ok(mission);
    }

    //Listar todas as Missões
    @GetMapping()
    public ResponseEntity<List<ToMissionResponseDto>> listMissions() {
        List<ToMissionResponseDto> missions = missionService.listOfAllMissions();
        return ResponseEntity.ok(missions);
    }
}
