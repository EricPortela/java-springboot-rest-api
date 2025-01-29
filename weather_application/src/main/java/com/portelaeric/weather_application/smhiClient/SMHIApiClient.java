package com.portelaeric.weather_application.smhiClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portelaeric.weather_application.dataModels.rain.RainResponse;
import com.portelaeric.weather_application.dataModels.temperature.TemperatureResponse;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@Component
public class SMHIApiClient {

    private static final String BASE_URL = "https://opendata-download-metobs.smhi.se/api/version/latest/";
    public TemperatureResponse getTemperatureData() throws Exception {
        // Step 1: Make HTTP request
        URL url = new URL(BASE_URL + "parameter/1/station-set/all/period/latest-hour/data.json");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000); // 5 seconds timeout
        connection.setReadTimeout(5000); // 5 seconds timeout

        // Step 2: Get response code
        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new Exception("Failed to fetch data. HTTP Code: " + responseCode);
        }

        // Step 3: Read response body
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Step 4: Deserialize JSON to Java object
        ObjectMapper objectMapper = new ObjectMapper();
        TemperatureResponse temperatureResponse = objectMapper.readValue(response.toString(), TemperatureResponse.class);

        return temperatureResponse;
    }


    //https://opendata-download-metobs.smhi.se/api/version/1.0/parameter/23/station/53430/period/latest-months/data.json
    public RainResponse getRainfallData() throws Exception {
        // Step 1: Make HTTP request
        URL url = new URL(BASE_URL + "parameter/23/station/53430/period/latest-months/data.json");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000); // 5 seconds timeout
        connection.setReadTimeout(5000); // 5 seconds timeout

        // Step 2: Get response code
        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new Exception("Failed to fetch data. HTTP Code: " + responseCode);
        }

        // Step 3: Read response body
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Step 4: Deserialize JSON to Java object
        ObjectMapper objectMapper = new ObjectMapper();
        RainResponse rainfallResponse = objectMapper.readValue(response.toString(), RainResponse.class);

        return rainfallResponse;
    }

}
