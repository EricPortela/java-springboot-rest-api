package com.portelaeric.weather_application.dataModels.commonModels;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StationParent {

    @JsonProperty("key")
    private String key;

    @JsonProperty("name")
    private String name;

    @JsonProperty("owner")
    private String owner;

    @JsonProperty("ownerCategory")
    private String ownerCategory;

    @JsonProperty("measuringStations")
    private String measuringStations;

    @JsonProperty("height")
    private double height;

    // Optionally, include getters and setters if needed
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnerCategory() {
        return ownerCategory;
    }

    public void setOwnerCategory(String ownerCategory) {
        this.ownerCategory = ownerCategory;
    }

    public String getMeasuringStations() {
        return measuringStations;
    }

    public void setMeasuringStations(String measuringStations) {
        this.measuringStations = measuringStations;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

