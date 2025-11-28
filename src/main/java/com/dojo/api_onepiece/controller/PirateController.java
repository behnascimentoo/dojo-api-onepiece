package com.dojo.api_onepiece.controller;

import com.dojo.api_onepiece.dto.CreatePirateDto;
import com.dojo.api_onepiece.dto.PirateResponseDto;
import com.dojo.api_onepiece.dto.UpdatePirateDto;
import com.dojo.api_onepiece.entity.RacePirate;
import com.dojo.api_onepiece.service.PirateService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/pirate")
//http://localhost:8080/pirate
public class PirateController {

    private final PirateService pirateService;


    //Criar Pirata
    @PostMapping
    public ResponseEntity<Void> createPirate (@Valid @RequestBody CreatePirateDto createPirateDto){
        pirateService.savePirate(createPirateDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //Atualizar Pirata
    @PutMapping("/id/{id}")
    public ResponseEntity<PirateResponseDto> updatePirate(@PathVariable Long id, @Valid @RequestBody UpdatePirateDto updatePirateDto){
        PirateResponseDto updatePirate = pirateService.updatePirate(id, updatePirateDto);
        return ResponseEntity.ok(updatePirate);
    }

    //Buscar Pirata por id
    @GetMapping("/id/{id}")
    public ResponseEntity<PirateResponseDto> searchPirataById(@PathVariable Long id){
        PirateResponseDto pirate = pirateService.getPirateById(id);
        return ResponseEntity.ok(pirate);
    }

    //Buscar pirata por raça
    //http://localhost:8080/pirate?racePirate=HUMANO
    @GetMapping()
    public ResponseEntity<List<PirateResponseDto>> listPirates(@RequestParam(required = false) RacePirate racePirate){
        List<PirateResponseDto> list = racePirate == null ? pirateService.listOfAllPirates() : pirateService.findPiratesByRace(racePirate);
        return ResponseEntity.ok(list);
    }

    //Apagar Pirata
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> removePirate(@PathVariable Long id){
        pirateService.deletePirate(id);
        return ResponseEntity.ok().build();
    }

}
