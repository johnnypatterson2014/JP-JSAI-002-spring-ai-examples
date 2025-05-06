package com.calamansi.demo.service;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

import com.calamansi.demo.integration.OpenAiIntegration;

@Service
public class ChatService {

	private final OpenAiIntegration openAiIntegration;

	public ChatService(OpenAiIntegration openAiIntegration) {
		this.openAiIntegration = openAiIntegration;
	}

	public String queryLLM(String message) {
		
		String chatResponse = openAiIntegration.callLLM(message);
		return chatResponse;
		
	}

}
