package com.calamansi.demo.integration;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ChatClient.CallResponseSpec;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Component;

@Component
public class OpenAiIntegration {

	private final ChatClient chatClient;

	public OpenAiIntegration(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}
	
	public String callLLM(String message) {
		
		CallResponseSpec callResponseSpec = chatClient.prompt().user(message).call();
		ChatResponse response = callResponseSpec.chatResponse();
		String responseString = response.getResult().getOutput().getText();
		return responseString;
	}
	
	
}
