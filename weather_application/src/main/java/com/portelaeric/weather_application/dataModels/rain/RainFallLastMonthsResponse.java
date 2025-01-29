package com.portelaeric.weather_application.dataModels.rain;

public class RainFallLastMonthsResponse {

    private String start;
    private String end;
    private Double rainfall;
    private String unit;
    private String status;

    public RainFallLastMonthsResponse(String start, String end, Double rainfall, String unit, String status) {
        this.start = start;
        this.end = end;
        this.rainfall = rainfall;
        this.unit = unit;
        this.status = status;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Double getRainfall() {
        return rainfall;
    }

    public void setRainfall(Double rainfall) {
        this.rainfall = rainfall;
    }

    public String getUnit() { return unit; }

    public void setUnit(String unit) { this.unit = unit; }

    public String getStatus() { return status; }

    public void setStatus(String status) {this.status = status;}

}
