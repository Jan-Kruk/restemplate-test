package com.janek.restemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.janek.restemplate.proxy.itunes.ItunesProxy;
import com.janek.restemplate.proxy.itunes.ITunesResponse;
import com.janek.restemplate.proxy.sampleshawnmendes.SampleShawenMendesServerProxy;
import com.janek.restemplate.proxy.sampleshawnmendes.SampleShawnMendesResponse;
import com.janek.restemplate.service.ITunesService;
import com.janek.restemplate.service.ShawnMendesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class RestemplateApplication {

	ITunesService iTunesService;

	ShawnMendesService shawnMendesService;
	@Autowired
	public RestemplateApplication(ITunesService iTunesService, ShawnMendesService shawnMendesService) {
		this.iTunesService = iTunesService;
		this.shawnMendesService = shawnMendesService;
	}

	public static void main(String[] args) {
		SpringApplication.run(RestemplateApplication.class, args);
	}

	@EventListener(ApplicationStartedEvent.class)
	public void run() throws JsonProcessingException {
		iTunesService.dosth();
		shawnMendesService.dosth();
	}


}
