package com.calamansi.demo.controller;

import static org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor.CHAT_MEMORY_CONVERSATION_ID_KEY;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;

@RestController
@Slf4j
public class RagPdfController {
	
	private final ChatClient chatClient;
	
//	@Value("classpath:data/anthropic.pdf")
    private Resource documentResource;

	@Autowired
	public RagPdfController(
			@Value("classpath:data/anthropic.pdf") Resource documentResource,
			ChatClient.Builder builder, 
			VectorStore vectorStore) {
		
		this.documentResource = documentResource;
		
		MessageChatMemoryAdvisor messageChatMemoryAdvisor = new MessageChatMemoryAdvisor(new InMemoryChatMemory());
		
		TikaDocumentReader documentReader = new TikaDocumentReader(documentResource);
        TextSplitter textSplitter = new TokenTextSplitter();
        vectorStore.accept(
            textSplitter.apply(
                documentReader.get()));
		
		this.chatClient = builder
				.defaultAdvisors(
						messageChatMemoryAdvisor,
						new QuestionAnswerAdvisor(vectorStore),
						new SimpleLoggerAdvisor()
						)
				.build();
	}
	
	@GetMapping("/rag/qa-over-pdf")
    public ChatResponse qaOverPdf(
    		@RequestParam(value = "message", defaultValue = "What is this article about? Please summarize in one paragraph.") String message,
    		@RequestHeader(name="X_CONV_ID", defaultValue="defaultConversation") String conversationId
    		) {
		
		log.debug("Entered /rag/qa-over-pdf");
		log.debug("conversationId: " + conversationId);
    	
		ChatResponse chatResponse = chatClient.prompt()
		        .user(message)
		        .advisors(spec -> spec.param(CHAT_MEMORY_CONVERSATION_ID_KEY, conversationId))
		        .call()
		        .chatResponse();
		
		log.debug("chatResponse: " + chatResponse);
		return chatResponse;
    }
	
	

}
