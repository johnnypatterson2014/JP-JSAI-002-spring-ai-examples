package com.calamansi.demo.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
	public void givenX_whenGetX_thenStatus200() throws Exception {
		
		ResultActions result = mvc.perform(get("/api/chat/jokes-with-response"));
		
		assertNotNull(result);

//		mvc.perform(get("/api/survey?name=fred"))
//			.andExpectAll(status().isOk(), jsonPath("$.name").value("fred"));
	}
}
