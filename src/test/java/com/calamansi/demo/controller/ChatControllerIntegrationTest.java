package com.calamansi.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.calamansi.demo.Application;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class ChatControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void test_queryLLM() throws Exception {
		
		ResultActions result = mvc.perform(get("/api/chat/query"));
		assertNotNull(result);
		String textResponse = result.andReturn().getResponse().getContentAsString();
		assertNotNull(textResponse);
		System.out.println(textResponse);
		
//		mvc.perform(get("/api/survey?name=fred"))
//			.andExpectAll(status().isOk(), jsonPath("$.name").value("fred"));
	}
	
	@Test
	public void test_queryLLMWithChatResponse() throws Exception {
		
		ResultActions result = mvc.perform(get("/api/chat/query-with-response"));
		assertNotNull(result);
		
		MockHttpServletResponse chatResponse = result.andReturn().getResponse();
		assertEquals(200, chatResponse.getStatus());
		System.out.println(chatResponse);
		
	}
}
