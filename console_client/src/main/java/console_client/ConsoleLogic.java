package console_client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;


public class ConsoleLogic {

    private String urlBase;

    public ConsoleLogic(String urlBase) {
        this.urlBase = urlBase;
    }

    public void taskOne(String endpoint) {
        try {
            JSONObject json = fetchFromEndpoint(endpoint);

            double averageTemperature = json.getDouble("averageTemperature");

            System.out.println("The average temperature in Sweden for the last hours was " + averageTemperature + " degrees");
        }

        catch(Exception ex) {
            System.out.println("Something went wrong with task 1...");
        }
    }

    public void taskTwo(String endpoint) {
        try {
            JSONObject json = fetchFromEndpoint(endpoint);

            double rainfall = json.getDouble("rainfall");
            String unit = json.getString("unit");
            String start = json.getString("start");
            String end = json.getString("end");

            System.out.println("Between " + start + " and " + end + " the total rainfall in Lund was " + rainfall + " " + unit);
        }

        catch(Exception ex) {
            System.out.println("Something went wrong with task 2...");
        }
    }

    public void taskThree(String endpoint) {
        try {
            JSONObject json = fetchFromEndpoint(endpoint);

            JSONArray institutes = json.getJSONArray("institutes");

            Thread keyListenerThread = new Thread(() -> {

                for (int i = 0; i<institutes.length(); i++) {

                    JSONObject institute = institutes.getJSONObject(i);

                    String instituteName = institute.getString("instituteName");
                    Double instituteTemperature = institute.getDouble("temperature");

                    System.out.println(instituteName + ": " + instituteTemperature);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); //Restores the prev sleeping t
                    }
                }
            });

            keyListenerThread.start(); // Start listening for key presses
            System.in.read();
            keyListenerThread.stop();
        }

        catch(Exception ex) {
            System.out.println("Something went wrong with task 3...");
        }
    }


    private JSONObject fetchFromEndpoint(String endpoint) throws Exception {

        String fullUrl = urlBase + "/" + endpoint;

        HttpURLConnection conn = (HttpURLConnection) new URL(fullUrl).openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new Exception("Couldn't retrieve correctly from endpoint!");
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            response.append(line);
        }

        br.close();
        conn.disconnect();

        JSONObject jo = new JSONObject(response.toString());

        return jo;
    }
}
