package com.calamansi.demo.controller;

import java.util.List;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calamansi.demo.model.Answer;
import com.calamansi.demo.model.Itinerary;
import com.calamansi.demo.model.Question;
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
    public ChatResponse queryLLMWithChatResponse(
    		@RequestParam(value = "message", defaultValue = "Tell me a joke about computers") String message,
    		@RequestHeader(name="X_CONV_ID", defaultValue="defaultConversation") String conversationId) {
		log.debug("X_CONV_ID is: " + conversationId);
    	return chatService.callLLMWithChatResponse(message);
    }
	
	@GetMapping("query-stream")
	public Flux<String> queryStream(@RequestParam(value = "message", defaultValue = "I am visiting Atlanta, GA can you give me 10 places I must visit") String message) {
    	return chatService.queryStream(message);
    }
	
	@PostMapping("chat-with-memory")
    public Answer chatWithMemory(
    		@RequestBody Question question,
    	    @RequestHeader(name="X_CONV_ID", defaultValue="defaultConversation") String conversationId) {
		
		log.debug("X_CONV_ID is: " + conversationId);
		Answer a = chatService.chat(question.question(), conversationId);
		log.debug("LLM response: " + a.toString());
		return a;
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
