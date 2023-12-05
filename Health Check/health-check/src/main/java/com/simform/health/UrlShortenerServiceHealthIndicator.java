package com.simform.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.Socket;

@Component
public class UrlShortenerServiceHealthIndicator implements HealthIndicator, HealthContributor {

    private static final String URL = "https://cleanuri.com/api/v1/shorten";

    @Override
    public Health health() {
        try (Socket socket = new Socket(new java.net.URL(URL).getHost(), 80)) {
        } catch (Exception e) {
            return Health.down().withDetail("error", e.getMessage()).build();
        }
        return Health.up().build();
    }
}

