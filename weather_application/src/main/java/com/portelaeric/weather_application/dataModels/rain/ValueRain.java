package com.portelaeric.weather_application.dataModels.rain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.portelaeric.weather_application.dataModels.commonModels.ValueParent;

import java.math.BigInteger;

public class ValueRain extends ValueParent {

    @JsonProperty("from")
    private BigInteger from;

    @JsonProperty("to")
    private BigInteger to;

    @JsonProperty("ref")
    private String ref;

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

    // Getter and Setter for 'ref'
    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
