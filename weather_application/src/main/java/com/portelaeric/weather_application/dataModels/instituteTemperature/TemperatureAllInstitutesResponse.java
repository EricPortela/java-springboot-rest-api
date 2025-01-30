package com.portelaeric.weather_application.dataModels.instituteTemperature;
import java.util.*;
public class TemperatureAllInstitutesResponse {

    private List<InstituteTemperature> institutes;
    private String status;

    public TemperatureAllInstitutesResponse (List<InstituteTemperature> institutes, String status) {
        this.institutes = institutes;
        this.status = status;
    }
    public void setInstitutes(List<InstituteTemperature> institutes) {
        this.institutes = institutes;
    }
    public List<InstituteTemperature> getInstitutes() {
        return institutes;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}

