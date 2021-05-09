package com.WebApplication3KW.controller;

import com.WebApplication3KW.dto.GreetingDTO;
import com.WebApplication3KW.dto.MessageDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public GreetingDTO send(MessageDTO message) {
        GreetingDTO greetingDTO = new GreetingDTO("Hello, " + HtmlUtils.htmlEscape(message.getText()));
        return greetingDTO;
    }
}
