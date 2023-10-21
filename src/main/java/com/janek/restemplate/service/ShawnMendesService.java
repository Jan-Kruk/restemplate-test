package com.janek.restemplate.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.janek.restemplate.proxy.itunes.ITunesResponse;
import com.janek.restemplate.proxy.sampleshawnmendes.SampleShawenMendesServerProxy;

import com.janek.restemplate.proxy.sampleshawnmendes.SampleShawnMendesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShawnMendesService {
    SampleShawenMendesServerProxy sampleShawnMendesServerClient;
    @Autowired
    public ShawnMendesService(SampleShawenMendesServerProxy sampleShawnMendesServerClient) {
        this.sampleShawnMendesServerClient = sampleShawnMendesServerClient;
    }

    private SampleShawnMendesResponse mapJsonToSampleShawnMendesResponse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, SampleShawnMendesResponse.class);
    }
    public void dosth() throws JsonProcessingException {
        sampleShawnMendesServerClient.makeDeleteRequest();
        String jsonShawnMendesSampleServer = sampleShawnMendesServerClient.makeRequest();
        if (jsonShawnMendesSampleServer != null){
            SampleShawnMendesResponse sampleShawnMendesResponse = mapJsonToSampleShawnMendesResponse(jsonShawnMendesSampleServer);
            System.out.println(sampleShawnMendesResponse);
        }
    }

}
