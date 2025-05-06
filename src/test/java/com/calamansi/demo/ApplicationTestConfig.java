package com.calamansi.demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.calamansi.demo.integration.OpenAiIntegration;
import com.calamansi.demo.service.ChatService;


@TestConfiguration
public class ApplicationTestConfig {

	@Bean
	public OpenAiIntegration openAiIntegration(ChatClient.Builder builder) {
		return new OpenAiIntegration(builder);
	}
	
	@Bean
	public ChatService chatService(OpenAiIntegration openAiIntegration) {
		ChatService chatService = new ChatService(openAiIntegration);
		return chatService;
	}
}
