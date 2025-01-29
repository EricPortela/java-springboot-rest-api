package com.portelaeric.weather_application.dataModels.commonModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Parameter {

    @JsonProperty("key") // JSON property for 'key'
    private String key;

    @JsonProperty("name") // JSON property for 'name'
    private String name;

    @JsonProperty("summary") // JSON property for 'summary'
    private String summary;

    @JsonProperty("unit") // JSON property for 'unit'
    private String unit;

    // Getters and Setters
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
