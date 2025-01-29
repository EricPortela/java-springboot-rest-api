package com.portelaeric.weather_application.dataModels.temperature;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.portelaeric.weather_application.dataModels.commonModels.Parameter;
import com.portelaeric.weather_application.dataModels.commonModels.Period;

import java.util.ArrayList;
import java.util.List;

public class TemperatureResponse {

    @JsonProperty("updated") // JSON property for 'updated'
    private String updated;

    @JsonProperty("parameter") // JSON property for 'parameter'
    private Parameter parameter;

    @JsonProperty("period") // JSON property for 'period'
    private Period period;

    @JsonProperty("link") // JSON property for 'link'
    private List<Link> link;

    @JsonProperty("station") // JSON property for 'station'
    private List<StationTemperature> station;

    // Getters and Setters
    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public List<Link> getLink() {
        return link;
    }

    public void setLink(List<Link> link) {
        this.link = link;
    }

    public List<StationTemperature> getStation() {
        return station;
    }

    public void setStation(List<StationTemperature> station) {
        this.station = station;
    }
}
