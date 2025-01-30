package com.portelaeric.weather_application.dataModels.instituteTemperature;

public class InstituteTemperature{
    private String instituteName;
    private Double temperature;

    public InstituteTemperature(String instituteName, Double temperature) {
        this.instituteName = instituteName;
        this.temperature = temperature;
    }

    public void setInstituteName(String instituteName) { this.instituteName = instituteName;}
    public String getInstituteName() { return instituteName;}

    public void setTemperature(Double temperature) { this.temperature = temperature; }
    public Double getTemperature() { return temperature;}
}