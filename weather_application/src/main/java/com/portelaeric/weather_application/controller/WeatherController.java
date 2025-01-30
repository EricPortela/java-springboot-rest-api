package com.portelaeric.weather_application.controller;

import com.portelaeric.weather_application.dataModels.instituteTemperature.TemperatureAllInstitutesResponse;
import com.portelaeric.weather_application.dataModels.rain.RainFallLastMonthsResponse;
import com.portelaeric.weather_application.dataModels.temperature.AverageTemperatureResponse;
import com.portelaeric.weather_application.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    // Injecting WeatherService into the controller
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    // Endpoint to get the average temperature for Sweden in the last hour
    @GetMapping("/average-temperature")
    public AverageTemperatureResponse getAverageTemperature() {
        AverageTemperatureResponse averageTemperature = weatherService.getAverageTemperature();

        return averageTemperature;
    }

    @GetMapping("/rainfall")
    public RainFallLastMonthsResponse RainFallLastMonths() {
        RainFallLastMonthsResponse rainfall = weatherService.getTotalRainfall();

        return rainfall;
    }

    @GetMapping("/temperature-institutes")
    public TemperatureAllInstitutesResponse TemperatureAllInstitutes() {
        TemperatureAllInstitutesResponse temperatureAllInstitutes = weatherService.getTemperatureForAllInstitutes();

        return temperatureAllInstitutes;
    }
}
