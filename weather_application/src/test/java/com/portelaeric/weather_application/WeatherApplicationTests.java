package com.portelaeric.weather_application;

import com.portelaeric.weather_application.dataModels.temperature.AverageTemperatureResponse;
import com.portelaeric.weather_application.dataModels.temperature.StationTemperature;
import com.portelaeric.weather_application.dataModels.temperature.TemperatureResponse;
import com.portelaeric.weather_application.dataModels.temperature.ValueTemperature;
import com.portelaeric.weather_application.service.WeatherService;
import com.portelaeric.weather_application.smhiClient.SMHIApiClient;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;


@SpringBootTest
class WeatherApplicationTests {

    @Mock
    private SMHIApiClient smhiApiClient;

    private WeatherService weatherService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        weatherService = new WeatherService(smhiApiClient);
    }

    @Test
    public void testGetAverageTemperature_Success() throws Exception {


        ValueTemperature valueTemperature1 = new ValueTemperature();
        valueTemperature1.setValue("-6.2");  // The temperature value for Abisko Aut station

        StationTemperature stationTemperature1 = new StationTemperature();
        stationTemperature1.setKey("188790");
        stationTemperature1.setName("Abisko Aut");
        stationTemperature1.setValue(Arrays.asList(valueTemperature1)); // Adding the temperature value

        ValueTemperature valueTemperature2 = new ValueTemperature();
        valueTemperature2.setValue("-6.7");  // The temperature value for Abisko Aut station

        StationTemperature stationTemperature2 = new StationTemperature();
        stationTemperature2.setKey("158990");
        stationTemperature2.setName("Abraur");
        stationTemperature2.setValue(Arrays.asList(valueTemperature2));  // No temperature values

        // Create the mock TemperatureResponse with the station data
        TemperatureResponse temperatureResponse = new TemperatureResponse();
        temperatureResponse.setStation(Arrays.asList(stationTemperature1, stationTemperature2));

        // Mock smhiApiClient to return the mocked data
        doReturn(temperatureResponse).when(smhiApiClient).getTemperatureData();

        // Call the method
        AverageTemperatureResponse response = weatherService.getAverageTemperature();

        System.out.println(response);

        // Assert the response
        assertNotNull(response);
        assertEquals("Success", response.getStatus());
        assertEquals(-6.45, response.getAverageTemperature());  // The average should be -6.2 since only one station has data
    }

    /*

    @Test
    public void testGetAverageTemperature_NoValidData() {
        // Create mock temperature data with no valid temperature values
        StationTemperature stationTemperature2 = new StationTemperature();
        stationTemperature2.setValue(Arrays.asList()); // No temperature data

        TemperatureResponse temperatureResponse = new TemperatureResponse();
        temperatureResponse.setStation(Arrays.asList(stationTemperature2));

        // Mock smhiApiClient to return the mocked data
        when(smhiApiClient.getTemperatureData()).thenReturn(temperatureResponse);

        // Call the method
        AverageTemperatureResponse response = temperatureService.getAverageTemperature();

        // Assert the response for no valid temperature data
        assertNotNull(response);
        assertEquals("No valid temperature data available", response.getMessage());
        assertNull(response.getAverageTemperature());
    }


    @Test
    public void testGetAverageTemperature_ErrorFetchingData() {
        // Mock smhiApiClient to throw an exception
        when(smhiApiClient.getTemperatureData()).thenThrow(new RuntimeException("API error"));

        // Call the method
        AverageTemperatureResponse response = temperatureService.getAverageTemperature();

        // Assert the response for error
        assertNotNull(response);
        assertEquals("Error fetching temperature data", response.getMessage());
        assertNull(response.getAverageTemperature());
    }
    */

}
