package com.calamansi.demo.service;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

import com.calamansi.demo.integration.OpenAiIntegration;
import com.calamansi.demo.model.Itinerary;

import reactor.core.publisher.Flux;

@Service
public class ChatService {

	private final OpenAiIntegration openAiIntegration;

	public ChatService(final OpenAiIntegration openAiIntegration) {
		this.openAiIntegration = openAiIntegration;
	}

	public String queryLLM(String message) {
		String chatResponse = openAiIntegration.callLLM(message);
		return chatResponse;
	}
	
	public ChatResponse callLLMWithChatResponse(String message) {
		return openAiIntegration.callLLMWithChatResponse(message);
	}

	public Flux<String> queryStream(String message) {
		return openAiIntegration.queryStream(message);
	}

	public ChatResponse chatWithMemory(String message) {
		return openAiIntegration.chatWithMemory(message);
	}

	public Itinerary vacationStructured() {
		return openAiIntegration.vacationStructured();
	}

}
