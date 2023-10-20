package com.janek.restemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class RestemplateApplication {

	@Autowired
	ItunesProxy shawnMendesClient;

	@Autowired
	SampleShawenMendesServerProxy sampleShawenMendesServerProxy;

	public static void main(String[] args) {
		SpringApplication.run(RestemplateApplication.class, args);
	}

	@EventListener(ApplicationStartedEvent.class)
	public void run() throws JsonProcessingException {
		String json = shawnMendesClient.makeShawnMendesRequest("shawnmendes",1);
		if (json != null){
			ShawnMendesResponse shawnMendesResponse = mapJsonToShawnMendesResponse(json);
			System.out.println(shawnMendesResponse);
		}
		sampleShawenMendesServerProxy.makeDeleteRequest();
		String jsonShawnMendesSampleServer = sampleShawenMendesServerProxy.makeRequest();
		if (jsonShawnMendesSampleServer != null){
			SampleShawnMendesResponse sampleShawnMendesResponse = mapJsonToSampleShawnMendesResponse(jsonShawnMendesSampleServer);
			System.out.println(sampleShawnMendesResponse);
		}

	}
	private ShawnMendesResponse mapJsonToShawnMendesResponse(String json) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, ShawnMendesResponse.class);
	}
	private SampleShawnMendesResponse mapJsonToSampleShawnMendesResponse(String json) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, SampleShawnMendesResponse.class);
	}
}
