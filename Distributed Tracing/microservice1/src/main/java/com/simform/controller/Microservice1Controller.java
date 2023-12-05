package com.simform.controller;

import brave.sampler.Sampler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Microservice1Controller {

    private final Logger LOGGER = LoggerFactory.getLogger(Microservice1Controller.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/microservice1")
    public String method1() {
        LOGGER.info("Inside method1");
        String baseUrl = "http://localhost:8081/microservice2";
        String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
        LOGGER.info("The response received by method1 is " + response);
        return response;
    }
}
