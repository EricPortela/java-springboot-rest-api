package com.portelaeric.weather_application.dataModels.commonModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigInteger;

public class Period {

    @JsonProperty("key") // JSON property for 'key'
    private String key;

    @JsonProperty("from") // JSON property for 'from'
    private BigInteger from;

    @JsonProperty("to") // JSON property for 'to'
    private BigInteger to;

    @JsonProperty("summary") // JSON property for 'summary'
    private String summary;

    @JsonProperty("sampling") // JSON property for 'sampling'
    private String sampling;

    // Getters and Setters
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public BigInteger getFrom() {
        return from;
    }

    public void setFrom(BigInteger from) {
        this.from = from;
    }

    public BigInteger getTo() {
        return to;
    }

    public void setTo(BigInteger to) {
        this.to = to;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSampling() {
        return sampling;
    }

    public void setSampling(String sampling) {
        this.sampling = sampling;
    }
}
