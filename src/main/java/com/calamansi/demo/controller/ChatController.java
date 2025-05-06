package com.calamansi.demo.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calamansi.demo.service.ChatService;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

	
	private final ChatService chatService;


    public ChatController(ChatService chatService) {
		this.chatService = chatService;
	}

    /**
     * What if you didn't want to get a String back, and you wanted the whole response?
     * @param message
     * @return
     */
    @GetMapping("jokes-with-response")
    public ChatResponse jokeWithResponse(@RequestParam(value = "message", defaultValue = "Tell me a dad joke about computers") String message) {
    	return chatService.jokeWithResponse(message);
    }
    
}
