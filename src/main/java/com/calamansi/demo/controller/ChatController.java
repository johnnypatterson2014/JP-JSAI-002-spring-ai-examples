package com.calamansi.demo.controller;

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

    public ChatController(final ChatService chatService) {
		this.chatService = chatService;
	}

	@GetMapping("query")
    public String queryLLM(@RequestParam(value = "message", defaultValue = "Tell me a joke about computers") String message) {
    	return chatService.queryLLM(message);
    }
	
	@GetMapping("query-with-response")
    public ChatResponse queryLLMWithChatResponse(@RequestParam(value = "message", defaultValue = "Tell me a joke about computers") String message) {
    	return chatService.callLLMWithChatResponse(message);
    }
    
}
