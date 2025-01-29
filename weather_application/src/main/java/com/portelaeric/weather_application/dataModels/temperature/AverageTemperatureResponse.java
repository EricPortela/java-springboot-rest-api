package com.portelaeric.weather_application.dataModels.temperature;

public class AverageTemperatureResponse {
    private Double averageTemperature;  // Use Double to allow null
    private String status;

    // Constructors, Getters, and Setters
    public AverageTemperatureResponse(Double averageTemperature, String status) {
        this.averageTemperature = averageTemperature;
        this.status = status;
    }

    public Double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(Double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
