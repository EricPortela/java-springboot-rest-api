package com.portelaeric.weather_application.dataModels.temperature;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Link {

    @JsonProperty("href") // JSON property for 'href'
    private String href;

    @JsonProperty("rel") // JSON property for 'rel'
    private String rel;

    @JsonProperty("type") // JSON property for 'type'
    private String type;

    // Getters and Setters
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
