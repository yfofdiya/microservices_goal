package com.simform.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Microservice4Controller {

    private final Logger LOGGER = LoggerFactory.getLogger(Microservice4Controller.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/microservice4")
    public String method4() {
        LOGGER.info("Inside method4");
        return "Hello World JavaInUse";
    }
}
