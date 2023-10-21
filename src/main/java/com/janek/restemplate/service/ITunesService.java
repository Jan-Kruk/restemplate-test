package com.janek.restemplate.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.janek.restemplate.proxy.itunes.ITunesResponse;
import com.janek.restemplate.proxy.itunes.ItunesProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ITunesService {
    ItunesProxy ItunesClient;
    @Autowired
    public ITunesService(ItunesProxy itunesClient) {
        ItunesClient = itunesClient;
    }

    private ITunesResponse mapJsonToItunes(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ITunesResponse.class);
    }

    public void dosth() throws JsonProcessingException {
        String json = ItunesClient.makeShawnMendesRequest("shawnmendes",1);
        if (json != null){
            ITunesResponse shawnMendesResponse = mapJsonToItunes(json);
            System.out.println(shawnMendesResponse);
        }
    }
}
