package com.dojo.api_onepiece.controller;

import com.dojo.api_onepiece.service.MissionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class MissionController {

    private final MissionService missionService;

}
