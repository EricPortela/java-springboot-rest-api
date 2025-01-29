package com.portelaeric.weather_application.dataModels.rain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class Position {

    @JsonProperty("from")
    private BigInteger from;

    @JsonProperty("to")
    private BigInteger to;

    @JsonProperty("height")
    private Double height;

    @JsonProperty("latitude")
    private Double latitude;

    @JsonProperty("longitude")
    private Double longitude;

    // Getter and Setter for 'from'
    public BigInteger getFrom() {
        return from;
    }

    public void setFrom(BigInteger from) {
        this.from = from;
    }

    // Getter and Setter for 'to'
    public BigInteger getTo() {
        return to;
    }

    public void setTo(BigInteger to) {
        this.to = to;
    }

    // Getter and Setter for 'height'
    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    // Getter and Setter for 'latitude'
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    // Getter and Setter for 'longitude'
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
