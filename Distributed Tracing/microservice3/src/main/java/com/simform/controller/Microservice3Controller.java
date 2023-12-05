package com.simform.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Microservice3Controller {

    private final Logger LOGGER = LoggerFactory.getLogger(Microservice3Controller.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/microservice3")
    public String method1() {
        LOGGER.info("Inside method3");
        String baseUrl = "http://localhost:8083/microservice4";
        String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
        LOGGER.info("The response received by method3 is " + response);
        return response;
    }
}
