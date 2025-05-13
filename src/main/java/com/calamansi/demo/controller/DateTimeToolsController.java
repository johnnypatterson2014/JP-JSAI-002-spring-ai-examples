package com.calamansi.demo.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.calamansi.demo.tools.DateTimeTools;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/tools")
@Slf4j
public class DateTimeToolsController {

	private final ChatClient chatClient;

    public DateTimeToolsController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/tomorrow")
    public String tools() {
        return chatClient.prompt("What day is tomorrow?")
                .tools(new DateTimeTools())
                .call()
                .content();
    }
}
