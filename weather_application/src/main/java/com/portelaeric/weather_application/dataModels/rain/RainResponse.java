package com.portelaeric.weather_application.dataModels.rain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.portelaeric.weather_application.dataModels.commonModels.Parameter;
import com.portelaeric.weather_application.dataModels.temperature.Link;
import com.portelaeric.weather_application.dataModels.commonModels.Period;
import com.portelaeric.weather_application.dataModels.temperature.ValueTemperature;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RainResponse {

    @JsonProperty("updated") // JSON property for 'updated'
    private BigInteger updated;

    @JsonProperty("parameter") // JSON property for 'parameter'
    private Parameter parameter;

    @JsonProperty("station") // JSON property for 'station'
    private StationRain station;

    @JsonProperty("period") // JSON property for 'period'
    private Period period;

    @JsonProperty("position") // JSON property for 'position'
    private List<Position> position;

    @JsonProperty("link") // JSON property for 'link'
    private List<Link> link;

    @JsonProperty("value") // JSON property for 'value'
    private List<ValueRain> value;

    // Getter and Setter for 'updated'
    public BigInteger getUpdated() {
        return updated;
    }

    public void setUpdated(BigInteger updated) {
        this.updated = updated;
    }

    // Getter and Setter for 'parameter'
    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public StationRain getStation() {
        return station;
    }

    public void setStation(StationRain station) {
        this.station = station;
    }

    // Getter and Setter for 'period'
    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    // Getter and Setter for 'position'
    public List<Position> getPosition() { return position;}
    public void setPosition(List<Position> position) {
        this.position = position;
    }

    // Getter and Setter for 'link'
    public List<Link> getLink() {
        return link;
    }

    public void setLink(List<Link> link) {
        this.link = link;
    }

    // Getter and Setter for 'value'
    public List<ValueRain> getValue() {
        return value;
    }

    public void setValue(List<ValueRain> value) {
        this.value = value;
    }
}
