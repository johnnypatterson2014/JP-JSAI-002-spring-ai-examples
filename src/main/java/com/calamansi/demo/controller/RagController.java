package com.calamansi.demo.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/rag")
@Slf4j
public class RagController {

	private final ChatClient chatClient;

	public RagController(ChatClient.Builder builder, VectorStore vectorStore) {
		this.chatClient = builder
				.defaultAdvisors(new QuestionAnswerAdvisor(vectorStore))
				.build();
	}

	@GetMapping("/models")
	public String ragQuery(
			@RequestParam(value = "message", defaultValue = "List the top 3 Large Language Models when it comes to context window size.") String message) {
		return chatClient.prompt().user(message).call().content();
	}

}
