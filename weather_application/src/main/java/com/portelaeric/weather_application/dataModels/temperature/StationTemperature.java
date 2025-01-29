package com.portelaeric.weather_application.dataModels.temperature;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.portelaeric.weather_application.dataModels.commonModels.StationParent;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class StationTemperature extends StationParent {

    @JsonProperty("from")
    private BigInteger from;

    @JsonProperty("to")
    private BigInteger to;

    @JsonProperty("value")
    private List<ValueTemperature> value;

    @JsonProperty("latitude")
    private Double latitude;

    @JsonProperty("longitude")
    private Double longitude;


    public List<ValueTemperature> getValue() { return value; }

    public void setValue(List<ValueTemperature> value) {
        this.value = value;
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

    public void setTo(BigInteger to) { this.to = to;}

    public double getLatitude() {return latitude;}

    public void setLatitude(double latitude) {this.latitude = latitude;}

    public double getLongitude() {return longitude;}

    public void setLongitude(double longitude) { this.longitude = longitude;}

}
