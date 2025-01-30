package com.portelaeric.weather_application.dataModels.instituteTemperature;
import java.util.*;
public class TemperatureAllInstitutesResponse {

    private List<InstituteTemperature> list;
    private String status;

    public TemperatureAllInstitutesResponse (List<InstituteTemperature> list, String status) {
        this.list = list;
        this.status = status;
    }
    public void setList(List<InstituteTemperature> list) {
        this.list = list;
    }
    public List<InstituteTemperature> getList() {
        return list;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}

