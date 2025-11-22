package com.dojo.api_onepiece.controller;

import com.dojo.api_onepiece.dto.CreatePirateDto;
import com.dojo.api_onepiece.service.PirateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/pirata")
public class PirataController {

    private final PirateService pirataService;
    private CreatePirateDto pirataDto;


}
