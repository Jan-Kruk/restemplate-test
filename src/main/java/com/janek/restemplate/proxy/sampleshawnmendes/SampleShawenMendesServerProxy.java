package com.janek.restemplate.proxy.sampleshawnmendes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class SampleShawenMendesServerProxy {
    @Autowired
    RestTemplate restTemplate;

    @Value("${shawnmendes-server.service.url}")
    String url;

    @Value("${shawnmendes-server.service.port}")
    Integer port;

    public String makeRequest() {
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host(url)
                .port(port)
                .path("shawn/songs");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("requestId", "eloelo");
        HttpEntity<HttpHeaders> httpEntity = new HttpEntity<>(httpHeaders);
        try{
            ResponseEntity<String> response = restTemplate.exchange(
                    builder.build().toUri(),
                    HttpMethod.GET,
                    httpEntity,
                    String.class);
            return response.getBody();
        }catch (RestClientResponseException e){
            System.out.println(e.getStatusText() + " " + e.getStatusCode());
        }catch (ResourceAccessException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public String postRequest() {
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host(url)
                .port(port)
                .path("shawn/songs");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("requestId", "eloelo");
//        HttpEntity<HttpHeaders> httpEntity = new HttpEntity<>(httpHeaders);
        SampleShawnMendesRequest requestBody = new SampleShawnMendesRequest("hahahaha");
        HttpEntity<SampleShawnMendesRequest> httpEntityBody = new HttpEntity<>(requestBody, httpHeaders);
        try{
            ResponseEntity<String> response = restTemplate.exchange(
                    builder.build().toUri(),
                    HttpMethod.POST,
                    httpEntityBody,
                    String.class);
            return response.getBody();
        }catch (RestClientResponseException e){
            System.out.println(e.getStatusText() + " " + e.getStatusCode());
        }catch (ResourceAccessException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public String makeDeleteRequest() {
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host(url)
                .port(port)
                .path("shawn/songs")
                .queryParam("id", 0);
        try{
            ResponseEntity<String> response = restTemplate.exchange(
                    builder.build().toUri(),
                    HttpMethod.DELETE,
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
