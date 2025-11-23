package com.dojo.api_onepiece.controller;

import com.dojo.api_onepiece.dto.CreatePirateDto;
import com.dojo.api_onepiece.dto.ToPirateResponseDto;
import com.dojo.api_onepiece.dto.UpdatePirateDto;
import com.dojo.api_onepiece.entity.RacePirate;
import com.dojo.api_onepiece.service.PirateService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("pirate")
//https://localhost:8080/pirate
public class PirateController {

    private final PirateService pirateService;


    //Criar Pirata
    @PostMapping
    public ResponseEntity<Void> createPirate (@RequestBody CreatePirateDto createPirateDto){
        pirateService.savePirate(createPirateDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //Atualizar Pirata
    @PutMapping("/{id}")
    public ResponseEntity<ToPirateResponseDto> updatePirate(@PathVariable Long id, @RequestBody UpdatePirateDto updatePirateDto){
        ToPirateResponseDto updatePirate = pirateService.updatePirate(id, updatePirateDto);
        return ResponseEntity.ok(updatePirate);
    }

    //Buscar Pirata por id
    @GetMapping("/{id}")
    public ResponseEntity<ToPirateResponseDto> searchPirataById(@PathVariable Long id){
        ToPirateResponseDto pirate = pirateService.getPirateById(id);
        return ResponseEntity.ok(pirate);
    }

    //Buscar pirata por raça
    @GetMapping("/{race}")
    public ResponseEntity<ToPirateResponseDto> searchPirateByRace(@PathVariable RacePirate racePirate){
        ToPirateResponseDto pirate = pirateService.getPirateByRace(racePirate);
        return ResponseEntity.ok(pirate);
    }

    //Listar todos os piratas
    @GetMapping()
    public ResponseEntity<List<ToPirateResponseDto>> listPirates() {
        List<ToPirateResponseDto> pirates = pirateService.listOfAllPirates();
        return ResponseEntity.ok(pirates);
    }

    //Apagar Pirata
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePirate(@PathVariable Long id){
        pirateService.deletePirate(id);
        return ResponseEntity.ok().build();
    }


}
