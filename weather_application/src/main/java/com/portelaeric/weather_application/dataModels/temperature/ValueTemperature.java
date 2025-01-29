package com.portelaeric.weather_application.dataModels.temperature;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.portelaeric.weather_application.dataModels.commonModels.ValueParent;

import java.math.BigInteger;

public class ValueTemperature extends ValueParent {
    @JsonProperty("date") // JSON property name for 'date' field
    private BigInteger date;

    public BigInteger getDate() {
        return date;
    }

    public void setDate(BigInteger date) {
        this.date = date;
    }
}
