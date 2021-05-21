package com.WebApplication3KW.controller;

import com.WebApplication3KW.dto.ChartDTO;
import com.WebApplication3KW.service.ChartService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChartController {
    private final ChartService chartService;

    @MessageMapping("/chart")
    @SendTo("/topic/messages")
    public ChartDTO send() {
        return chartService.createRandomNumbers();
    }
}
