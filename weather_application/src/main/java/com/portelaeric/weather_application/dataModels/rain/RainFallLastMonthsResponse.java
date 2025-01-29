package com.portelaeric.weather_application.dataModels.rain;

public class RainFallLastMonthsResponse {

    private String start;
    private String end;
    private Double rainfall;
    private String unit;

    public RainFallLastMonthsResponse(String start, String end, Double rainfall, String unit) {
        this.start = start;
        this.end = end;
        this.rainfall = rainfall;
        this.unit = unit;
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

}
