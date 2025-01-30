package com.portelaeric.weather_application.service;

import com.portelaeric.weather_application.dataModels.rain.RainFallLastMonthsResponse;
import com.portelaeric.weather_application.dataModels.rain.RainResponse;
import com.portelaeric.weather_application.dataModels.rain.ValueRain;
import com.portelaeric.weather_application.dataModels.temperature.AverageTemperatureResponse;
import com.portelaeric.weather_application.dataModels.temperature.StationTemperature;
import com.portelaeric.weather_application.dataModels.temperature.ValueTemperature;
import com.portelaeric.weather_application.smhiClient.SMHIApiClient;
import com.portelaeric.weather_application.dataModels.temperature.TemperatureResponse;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Service
public class WeatherService {

    private SMHIApiClient smhiApiClient;
    public WeatherService(SMHIApiClient smhiApiClient) {
        this.smhiApiClient = smhiApiClient;
    }

    public AverageTemperatureResponse getAverageTemperature() {
        try {
            // Fetch the temperature data from SMHIApiClient
            TemperatureResponse temperatureResponse = smhiApiClient.getTemperatureData();

            // Calculate the average temperature from the fetched data
            double totalTemperature = 0;
            int count = 0;

            for (StationTemperature station : temperatureResponse.getStation()) {
                for (ValueTemperature value : station.getValue()) {
                    try {
                        // Convert the temperature value from String to double and accumulate
                        totalTemperature += Double.parseDouble(value.getValue());
                        count++;
                    } catch (NumberFormatException e) {
                        // Handle invalid values or missing temperatures gracefully
                        return new AverageTemperatureResponse(null, "Invalid temperature value: " + value.getValue());
                    }
                }
            }

            if (count == 0) {
                return new AverageTemperatureResponse(null, "No valid temperature data available");
            }
            return new AverageTemperatureResponse((totalTemperature / count), "Success");


        } catch (Exception e) {
            // Handle any errors that occurred while fetching or processing the data
            e.printStackTrace();
            return new AverageTemperatureResponse(null, "Error fetching temperature data");
        }
    }

    public RainFallLastMonthsResponse getTotalRainfall() {
        try {
            // Fetch the rainfall data from SMHIApiClient
            RainResponse rainfallResponse = smhiApiClient.getRainfallData();

            // Initialize variables
            double totalRainfall = 0;
            int count = 0;
            BigInteger startDate = null; // Earliest "from"
            BigInteger endDate = null;   // Latest "to"

            // Iterate through the rainfall values
            for (ValueRain valueRain : rainfallResponse.getValue()) {
                try {
                    // Parse and accumulate rainfall
                    totalRainfall += Double.parseDouble(valueRain.getValue());
                    count++;

                    // Extract timestamps
                    BigInteger from = valueRain.getFrom(); // Earliest date in this entry
                    BigInteger to = valueRain.getTo();     // Latest date in this entry

                    // Ensure proper ordering of timestamps (sanity check)
                    if (from != null && to != null && from.compareTo(to) > 0) {
                        System.out.println("Warning: 'from' date is greater than 'to' date! Skipping entry.");
                        continue; // Ignore incorrect data
                    }

                    // Find the absolute earliest `from`
                    if (startDate == null || from.compareTo(startDate) < 0) {
                        startDate = from;
                    }

                    // Find the absolute latest `to`
                    if (endDate == null || to.compareTo(endDate) > 0) {
                        endDate = to;
                    }

                } catch (NumberFormatException e) {
                    return new RainFallLastMonthsResponse(null, null, null, "mm", "Invalid rainfall value: " + valueRain.getValue());
                }
            }

            // Handle case where no valid data was found
            if (count == 0) {
                return new RainFallLastMonthsResponse(null, null, null, "mm", "No valid rainfall data available");
            }

            // Convert timestamps to readable date strings
            String start = (startDate != null) ? convertUnixTimestampToString(startDate) : null;
            String end = (endDate != null) ? convertUnixTimestampToString(endDate) : null;
            totalRainfall = Math.round(totalRainfall * 10.0) / 10.0;

            return new RainFallLastMonthsResponse(start, end, totalRainfall, "mm", "Success");

        } catch (Exception e) {
            e.printStackTrace();
            return new RainFallLastMonthsResponse(null, null, null, "mm", "Error fetching rainfall data");
        }
    }


    private String convertUnixTimestampToString(BigInteger unixTimestamp) {
        if (unixTimestamp == null) {
            return null;
        }
        // Create Date object directly from milliseconds
        Date date = new Date(unixTimestamp.longValue());

        // Format the date as yyyy-MM-dd
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC")); // Ensure UTC timezone for consistency

        return sdf.format(date);
    }


}
