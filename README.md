# axis-programming-assignment


## 0. Motivation

* I decided to approach this asignment from a full-stack standpoint and with the duties in this role in mind. 

* Although one could argue that a possible solution for the tasks could have been implemented in a more easy and straight-forward way, I wanted to showcase my skills in building...
    * REST-API service and 
    * connect it with a simple client that one can interact with from the console/terminal

## 1. Prerequisite

I highly suggest to run this application in IntelliJ as this is the environment I have used. I could not make it work in VSCode.

## 1. Structure of my assignment

* The general architecture of the system is provided below in a handwritten schema.

![alt text](attachments/IMG_9287.png)

* I have created mainly two applications:

        1. weather_application: A REST API 
        2. console_client: Client that is run in the console 

## 2. REST-API Structure

* The main code of the application is found under 

    ``` weather_application/src/main/java/com/porteleric/weather_application ```
    
* What is included?
* I have divided the application into 5 sections

      1. controller: folder carries the endpoint my REST API exposes (for example /average-temprature)
      2. dataModels: folder carries POJO classes that are used to map the JSON data to a simple PLain Java Class. I use some inheritance here and there.
      3. service: The actual business logic of the REST API is found here.
      4. smhiClient: A client which interacts with SMHI's API and more specifically the endpoints of interest in order to retrieve the neccessary data for the tasks
      (5. WeatherApplication.java: The entry-point for the application, includes main-class of course)
      
## 3. Console client



## 4. Endpoints

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


### Task 3: http://localhost:8080/
