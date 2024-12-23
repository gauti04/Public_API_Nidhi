package com.example.demo.controllers;

import com.example.demo.weather.WeatherData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
public class RestController {

    private final RestTemplate restTemplate;

    // Please refer https://open-meteo.com/en/docs
    private final String WEATHER_URL = "https://api.open-meteo.com/v1/forecast";

    public RestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/weather")
    public ResponseEntity<WeatherData> getWeather(@RequestParam Float latitude, @RequestParam Float longitude) {

        URI uri = UriComponentsBuilder.fromUriString(WEATHER_URL)
                .queryParam("latitude", latitude)
                .queryParam("longitude", longitude)
                .build()
                .encode()
                .toUri();
        return restTemplate.getForEntity(uri, WeatherData.class);
    }
}
