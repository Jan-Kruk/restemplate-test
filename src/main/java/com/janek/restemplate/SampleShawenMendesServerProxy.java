package com.janek.restemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Component
public class SampleShawenMendesServerProxy {
    @Autowired
    RestTemplate restTemplate;

    @Value("${shawnmendes2.local.url}")
    String url;

    public String makeShawnMendesRequest(String term, Integer limit) throws JsonProcessingException {
        String uri = url +"/search?term=" + term + "&limit=" + limit;
        return makeRequest(uri);
    }

    private String makeRequest(String uri) {
//        UriComponentsBuilder builder = UriComponentsBuilder.newInstance().queryParam("term","shawnMendes")
//                .queryParam("limit",2).scheme("https").host("itunes.apple.com");
        try{
            ResponseEntity<String> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    null,
                    String.class);
            return response.getBody();
        }catch (RestClientResponseException e){
            System.out.println(e.getStatusText() + " " + e.getStatusCode());
        }catch (ResourceAccessException e){
            System.out.println(e.getMessage());
        }
        return null;
    }


}
