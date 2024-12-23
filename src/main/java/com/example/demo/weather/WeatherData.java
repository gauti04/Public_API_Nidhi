package com.example.demo.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherData {
    private Float latitude;
    private Float longitude;
    private Float elevation;
    private String timezone;
}
