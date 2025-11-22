package com.dojo.api_onepiece.controller;

import com.dojo.api_onepiece.dto.CreatePirateDto;
import com.dojo.api_onepiece.service.PirateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("pirate")
//https://localhost:8080/pirate
public class PirateController {

    private final PirateService pirateService;



}
