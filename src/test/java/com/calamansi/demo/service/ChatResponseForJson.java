package com.calamansi.demo.service;

import java.util.List;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ChatResponseForJson extends ChatResponse {

	public ChatResponseForJson(List<Generation> generations) {
		super(generations);
		// TODO Auto-generated constructor stub
	}
	
	public ChatResponseForJson() {
		super(null);
	}

}
