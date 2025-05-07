package com.calamansi.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.util.Collections;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.DefaultChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.calamansi.demo.ApplicationTestConfig;
import com.calamansi.demo.integration.OpenAiIntegration;
import com.calamansi.demo.service.json2pojo.ChatResponseJson;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.mockito.internal.matchers.Any;

@SpringBootTest
@Import(ApplicationTestConfig.class)
public class ChatServiceTest {

	private ChatService chatService;

	private OpenAiIntegration openAiIntegration;

	@Value("classpath:json/chat.model.response.001.json")
	Resource chatModelResponse_001;

	@BeforeEach
	public void setup() {
		this.openAiIntegration = Mockito.mock(OpenAiIntegration.class);
		this.chatService = new ChatService(openAiIntegration);
	}

	@Test
	public void testing() throws StreamReadException, DatabindException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		ChatResponseJson stubResponse = mapper.readValue(chatModelResponse_001.getFile(), ChatResponseJson.class);
		String message = "tell me a joke";

		String stubResponseString = stubResponse.getResult().getOutput().getText();
		Mockito.when(openAiIntegration.callLLM(message)).thenReturn(stubResponseString);
		String response = chatService.queryLLM(message);

		assertEquals(
				"Why don't computers ever get tired?\n\nBecause they have a great byte-size nap every time they go to sleep!",
				response);

	}

}
