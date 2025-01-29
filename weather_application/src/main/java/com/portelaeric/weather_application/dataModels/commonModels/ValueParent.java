package com.portelaeric.weather_application.dataModels.commonModels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class ValueParent {

    @JsonProperty("value") // JSON property name for 'value' field
    private String value;

    @JsonProperty("quality") // JSON property name for 'quality' field
    private String quality;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}
