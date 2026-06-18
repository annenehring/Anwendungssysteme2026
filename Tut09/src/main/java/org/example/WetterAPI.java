package org.example;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//https://api.open-meteo.com/v1/forecast?latitude=52.5&longitude=13.4&current_weather=true
public class WetterAPI {
    static void main() {

        HttpClient client = HttpClient.newHttpClient();

        URI u = URI.create("https://api.open-meteo.com/v1/forecast?latitude=52.5&longitude=13.4&current_weather=true");
        HttpRequest req = HttpRequest.newBuilder().uri(u)
                .build();

        try{

            HttpResponse<String> resp = client.send(req,HttpResponse.BodyHandlers.ofString());
            System.out.println(resp.body());

            JSONObject obj = new JSONObject(resp.body());
            JSONObject curWeather = obj.getJSONObject("current_weather");
            double temp = curWeather.getDouble("temperature");
            double windSpeed = curWeather.getDouble("windspeed");

            System.out.println("temperatur: " + temp);
            System.out.println("Windgeschwindigkeit: " + windSpeed);


        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }








    }
}