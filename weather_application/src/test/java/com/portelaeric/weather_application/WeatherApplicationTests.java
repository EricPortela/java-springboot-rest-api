package com.portelaeric.weather_application;

import com.portelaeric.weather_application.dataModels.instituteTemperature.TemperatureAllInstitutesResponse;
import com.portelaeric.weather_application.dataModels.rain.RainFallLastMonthsResponse;
import com.portelaeric.weather_application.dataModels.rain.RainResponse;
import com.portelaeric.weather_application.dataModels.rain.StationRain;
import com.portelaeric.weather_application.dataModels.rain.ValueRain;
import com.portelaeric.weather_application.dataModels.temperature.AverageTemperatureResponse;
import com.portelaeric.weather_application.dataModels.temperature.StationTemperature;
import com.portelaeric.weather_application.dataModels.temperature.TemperatureResponse;
import com.portelaeric.weather_application.dataModels.temperature.ValueTemperature;
import com.portelaeric.weather_application.service.WeatherService;
import com.portelaeric.weather_application.smhiClient.SMHIApiClient;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
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
        // STEP 1 - I insert a mock datapoint with temperature value of -6.2 degress
        ValueTemperature valueTemperature1 = new ValueTemperature();
        valueTemperature1.setValue("-6.2");

        StationTemperature stationTemperature1 = new StationTemperature();
        stationTemperature1.setKey("188790");
        stationTemperature1.setName("Abisko Aut");
        stationTemperature1.setValue(Arrays.asList(valueTemperature1));

        // STEP 2 - I insert a mock datapoint with temperature value of -6.7 degress
        ValueTemperature valueTemperature2 = new ValueTemperature();
        valueTemperature2.setValue("-6.7");  // The temperature value for Abisko Aut station

        StationTemperature stationTemperature2 = new StationTemperature();
        stationTemperature2.setKey("158990");
        stationTemperature2.setName("Abraur");
        stationTemperature2.setValue(Arrays.asList(valueTemperature2));

        // STEP 3 - I insert a mock datapoint with a missing temperature value
        StationTemperature stationTemperature3 = new StationTemperature();
        stationTemperature3.setKey("148990");
        stationTemperature3.setName("Lund");
        stationTemperature3.setValue(Arrays.asList());  // No temperature values

        // STEP 4 - Create the mock TemperatureResponse with the station data
        TemperatureResponse temperatureResponse = new TemperatureResponse();
        temperatureResponse.setStation(Arrays.asList(stationTemperature1, stationTemperature2, stationTemperature3));

        // Mock smhiApiClient to return the mocked data
        doReturn(temperatureResponse).when(smhiApiClient).getTemperatureData();

        // Call the method
        AverageTemperatureResponse response = weatherService.getAverageTemperature();

        // Assert the response
        assertNotNull(response);
        assertEquals("Success", response.getStatus());
        assertEquals(-6.45, response.getAverageTemperature()); //I should expect an average temperature of 6.45
    }

    @Test
    public void testGetAverageTemperature_NoValidData() throws Exception {
        // Create mock temperature data with no valid temperature values
        StationTemperature stationTemperature2 = new StationTemperature();
        stationTemperature2.setValue(Arrays.asList()); // No temperature data

        TemperatureResponse temperatureResponse = new TemperatureResponse();
        temperatureResponse.setStation(Arrays.asList(stationTemperature2));

        // Make smhiApiClient return the above fake data
        doReturn(temperatureResponse).when(smhiApiClient).getTemperatureData();

        // Call the average temperature method
        AverageTemperatureResponse response = weatherService.getAverageTemperature();

        // Assert the response for no valid temperature data
        assertNotNull(response);
        assertEquals("No valid temperature data available", response.getStatus());
        assertNull(response.getAverageTemperature());
    }

    @Test
    public void testGetAverageTemperature_ErrorFetchingData() throws Exception {
        //Make smhiApiClient throw an exception
        when(smhiApiClient.getTemperatureData()).thenThrow(new RuntimeException("API error"));

        // Call the average temperature method
        AverageTemperatureResponse response = weatherService.getAverageTemperature();

        // Assert the response for error
        assertNotNull(response);
        assertEquals("Error fetching temperature data", response.getStatus());
        assertNull(response.getAverageTemperature());
    }










    @Test
    public void testRainfall_Success() throws Exception {

        // STEP 1 - I insert a mock datapoint with rainfall value of 120.1
        ValueRain valueRain1 = new ValueRain();
        valueRain1.setValue("120.1");
        valueRain1.setFrom(BigInteger.valueOf(676278));
        valueRain1.setTo(BigInteger.valueOf(776278));

        // STEP 2 - I insert a mock datapoint with rainfall value of 20.3
        ValueRain valueRain2 = new ValueRain();
        valueRain2.setValue("20.2");
        valueRain2.setFrom(BigInteger.valueOf(676278));
        valueRain2.setTo(BigInteger.valueOf(776278));

        // STEP 3 - I insert a mock datapoint with rainfall value of 90
        ValueRain valueRain3 = new ValueRain();
        valueRain3.setValue("90.3");
        valueRain3.setFrom(BigInteger.valueOf(676278));
        valueRain3.setTo(BigInteger.valueOf(776278));

        // STEP 4 - I insert a mock datapoint with empty rainfall
        //ValueRain valueRain4 = new ValueRain();

        // STEP 4 - Create the mock TemperatureResponse with the station data
        RainResponse rainResponse = new RainResponse();
        rainResponse.setValue(Arrays.asList(valueRain1, valueRain2, valueRain3)); //, valueRain4));

        // Mock smhiApiClient to return the mocked data
        doReturn(rainResponse).when(smhiApiClient).getRainfallData();

        // Call the method
        RainFallLastMonthsResponse response = weatherService.getTotalRainfall();

        // Assert the response
        assertNotNull(response);
        assertEquals("Success", response.getStatus());
        assertEquals(230.6, response.getRainfall());
    }


    @Test
    public void testRainfall_NoValidData() throws Exception {
        // Here I just insert empty values/list basically
        RainResponse rainResponse = new RainResponse();
        rainResponse.setValue(Arrays.asList()); //, valueRain4));

        // Mock smhiApiClient to return the mocked data
        doReturn(rainResponse).when(smhiApiClient).getRainfallData();

        // Call the method
        RainFallLastMonthsResponse response = weatherService.getTotalRainfall();

        // Assert the response
        assertNotNull(response);
        assertEquals("No valid rainfall data available", response.getStatus());
    }

    @Test
    public void testRainfall_ErrorFetchingData() throws Exception {
        //Make smhiApiClient throw an exception
        when(smhiApiClient.getRainfallData()).thenThrow(new RuntimeException("API error"));

        // Call the average temperature method
        RainFallLastMonthsResponse response = weatherService.getTotalRainfall();

        // Assert the response for error
        assertNotNull(response);
        assertEquals("Error fetching rainfall data", response.getStatus());
        assertNull(response.getRainfall());
    }









    @Test
    public void testTemperatureInstitute_Success() throws Exception {

        // STEP 1 - I insert a mock datapoint with temperature value of -6.2 degress
        ValueTemperature valueTemperature1 = new ValueTemperature();
        valueTemperature1.setValue("-6.2");

        StationTemperature stationTemperature1 = new StationTemperature();
        stationTemperature1.setKey("188790");
        stationTemperature1.setName("Abisko Aut");
        stationTemperature1.setValue(Arrays.asList(valueTemperature1));

        // STEP 2 - I insert a mock datapoint with temperature value of -6.7 degress
        ValueTemperature valueTemperature2 = new ValueTemperature();
        valueTemperature2.setValue("-6.7");  // The temperature value for Abisko Aut station

        StationTemperature stationTemperature2 = new StationTemperature();
        stationTemperature2.setKey("158990");
        stationTemperature2.setName("Abraur");
        stationTemperature2.setValue(Arrays.asList(valueTemperature2));

        // STEP 3 - I insert a mock datapoint with a missing temperature value
        StationTemperature stationTemperature3 = new StationTemperature();
        stationTemperature3.setKey("148990");
        stationTemperature3.setName("Lund");
        stationTemperature3.setValue(Arrays.asList());  // No temperature values

        TemperatureResponse temperatureResponse = new TemperatureResponse();
        temperatureResponse.setStation(Arrays.asList(stationTemperature1, stationTemperature2, stationTemperature3));

        // Mock smhiApiClient to return the mocked data
        doReturn(temperatureResponse).when(smhiApiClient).getTemperatureData();

        // Call the method
        TemperatureAllInstitutesResponse response = weatherService.getTemperatureForAllInstitutes();

        // Assert the response
        assertNotNull(response);
        assertEquals("Success", response.getStatus());

        assertEquals("Abisko Aut", response.getInstitutes().get(0).getInstituteName());
        assertEquals(-6.2, response.getInstitutes().get(0).getTemperature());

        assertEquals("Abraur", response.getInstitutes().get(1).getInstituteName());
        assertEquals(-6.7, response.getInstitutes().get(1).getTemperature());

    }



    @Test
    public void testTemperatureInstitute_NoValidData() throws Exception {
        // Create mock temperature data with no valid temperature values
        StationTemperature stationTemperature2 = new StationTemperature();
        stationTemperature2.setValue(Arrays.asList()); // No temperature data

        TemperatureResponse temperatureResponse = new TemperatureResponse();
        temperatureResponse.setStation(Arrays.asList(stationTemperature2));

        // Make smhiApiClient return the above fake data
        doReturn(temperatureResponse).when(smhiApiClient).getTemperatureData();

        // Call the average temperature method
        TemperatureAllInstitutesResponse response = weatherService.getTemperatureForAllInstitutes();

        // Assert the response for no valid temperature data
        assertNotNull(response);
        assertEquals("No valid temperature data available", response.getStatus());
        assertEquals(new ArrayList<>(), response.getInstitutes());
    }

    @Test
    public void testTemperatureInstitute_ErrorFetchingDataa() throws Exception {
        //Make smhiApiClient throw an exception
        when(smhiApiClient.getRainfallData()).thenThrow(new RuntimeException("API error"));

        // Call the average temperature method
        TemperatureAllInstitutesResponse response = weatherService.getTemperatureForAllInstitutes();

        // Assert the response for error
        assertNotNull(response);
        assertEquals("Error fetching temperature data", response.getStatus());
        assertNull(response.getInstitutes());
    }






}
