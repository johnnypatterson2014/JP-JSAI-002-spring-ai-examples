package com.calamansi.demo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
//@RequiredArgsConstructor
public class ChatService {

	private final ChatClient chatClient;

	public ChatService(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}

	public String getJoke(String message) {
		return chatClient.prompt().user(message).call().content(); // short for getResult().getOutput().getContent();
	}

	public ChatResponse jokeWithResponse(String message) {
		return chatClient.prompt().user(message).call().chatResponse();
	}

}
