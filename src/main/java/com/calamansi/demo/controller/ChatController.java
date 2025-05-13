package com.calamansi.demo.controller;

import java.util.List;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calamansi.demo.model.Itinerary;
import com.calamansi.demo.service.ChatService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/chat")
@Slf4j
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
	
	@GetMapping("query-stream")
	public Flux<String> queryStream(@RequestParam(value = "message", defaultValue = "I am visiting Atlanta, GA can you give me 10 places I must visit") String message) {
    	return chatService.queryStream(message);
    }
	
	@GetMapping("chat-with-memory")
    public ChatResponse chatWithMemory(@RequestParam(value = "message", defaultValue = "What are the 10 best beach vacation destinations for the current month?") String message) {
    	return chatService.chatWithMemory(message);
    }
	
	@GetMapping("/vacation-structured")
	public Itinerary vacationStructured() {
	    return chatService.vacationStructured();
	}
	
	
	// handy way to return a json string using a Map
	/*
	 
		@GetMapping("/ai/simple")
		public Map<String, String> completion(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
			return Map.of("completion", this.chatClient.prompt().user(message).call().content());
		}
		
		// example response:
		{"completion":"Why did the pirate go to the comedy club? To hear some arrr-rated jokes! Arrr, matey!"}
	 
    */
}
