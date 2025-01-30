# axis-programming-assignment


## 0. Motivation

* I decided to approach this asignment from a full-stack standpoint and with the duties in this role in mind. 

* Although one could argue that a possible solution for the tasks could have been implemented in a more easy and straight-forward way, I wanted to showcase my skills in building...
    * REST-API service and 
    * connect it with a simple client that one can interact with from the console/terminal

## 1. Prerequisite

I highly suggest to run this application in IntelliJ as this is the environment I have used. I could not make it work in VSCode.

## 2. Structure of my assignment

* The general architecture of the system is provided below in a handwritten schema.

![alt text](attachments/IMG_9287.png)

* I have created mainly two applications:

        1. weather_application: A REST API 
        2. console_client: Client that is run in the console 

## 3. REST-API Structure

* The main code of the application is found under 

    ``` weather_application/src/main/java/com/porteleric/weather_application ```
    
* What is included?
* I have divided the application into 5 sections

      1. controller: folder carries the endpoint my REST API exposes (for example /average-temprature)
      2. dataModels: folder carries POJO classes that are used to map the JSON data to a simple PLain Java Class. I use some inheritance here and there.
      3. service: The actual business logic of the REST API is found here.
      4. smhiClient: A client which interacts with SMHI's API and more specifically the endpoints of interest in order to retrieve the neccessary data for the tasks
      (5. WeatherApplication.java: The entry-point for the application, includes main-class of course)
      
## 4. Console client

* The main code of the application is found under

    ``` console_client/src/main/java/console_client ```

* I have divided the application into 2 parts

      1. ConsoleLogic.java: The logic behind the Console App. Includes mainly three methods that essentially parse the data exposed at the three endpoints my REST Service exposes. Meaning one method for each task/endpoint. There is also a fourth method which fetches the data from any endpoint and checks that the staus code is OK (200).
      2. ConsoleApplication.java: Has the main method of the console application.




## 5. Endpoints of the REST API

### Task 1: http://localhost:8080/average-temperature

```json
{
  "averageTemperature": -2.7499999999999996,
  "status": "Success"
}
```

* Uses this SMHI-endpoint: https://opendata-download-metobs.smhi.se/api/version/latest/parameter/1/station-set/all/period/latest-hour/data.json


### Task 2: http://localhost:8080/rainfall

```json
{
  "start": "2024-09-01",
  "end": "2025-01-01",
  "rainfall": 267.6,
  "unit": "mm",
  "status": "Success"
}
```

* Uses this SMHI-endpoint: https://opendata-download-metobs.smhi.se/api/version/latest/parameter/23/station/53430/period/latest-months/data.json


### Task 3: http://localhost:8080/temperature-institutes

```json
{
  "institutes": [
    {
      "instituteName": "Abisko Aut",
      "temperature": -3.6
    },
    {
      "instituteName": "AdelsÃ¶ A",
      "temperature": 1.5
    },
    {
      "instituteName": "Arjeplog A",
      "temperature": -7.3
    },
    {
      "instituteName": "Arvidsjaur A",
      "temperature": -6.7
    },
    {
      "instituteName": "Arvika A",
      "temperature": 0.5
    }
  ],
  "status": "Success"
}
```

* Uses this SMHI-endpoint: https://opendata-download-metobs.smhi.se/api/version/latest/parameter/1/station-set/all/period/latest-hour/data.json


## 6. Test cases for the REST API

* Decided to only implement test cases for the REST API given the fact that the majority of the logic lies in here
* More specifically I'm testing the methods found in WeatherService.java since the business logic is found here as well as the fact that I handle the various exceptions here.
* For the test cases I have mainly used the following frameworks:

    * Mockito: for mocking behaviour of the SMHIApiClient.java.
    * JUnit: Using the assert methods to ensure that the returned data is same as the expected one.

* I have made three test for each method in the WeatherService.java. The general structure of the test for each method is:

      1. test{method_name}Temperature_Success(): Tests when the data received from SMHIAPIClient is 'okay'
      2. test{method_name}Temperature_NoValidData(): Tests when data received from SMHIAPIClient is 'missing'
      3. test{method_name}Temperature_ErrorFetchingData(): Tests when data received from SMHIAPIClient returned an 'error'

