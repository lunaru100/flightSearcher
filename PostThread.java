package com.example.flight_przemylska_wolska.Threads;

import com.example.flight_przemylska_wolska.Connectors.PostRequester;

public class PostThread extends Thread {
    @Override
    public void run() {
        String serverUrl = "http://192.168.1.154:8080/aa/postFlights";
        String jsonData = "{\"id\":\"1\",\"dest\":\"Gdansk\", \"price\":\"900\"}";
//        String serverUrl = "http://192.168.1.100:8080/cos/wilenski";
//        String jsonData = "{\"number\":\"2\",\"destination\":\"postTest\", \"ticketPrice\":\"999\"}";
        System.out.println(jsonData);
        PostRequester postRequester = new PostRequester();
        postRequester.execute(serverUrl, jsonData);
        String a = postRequester.doInBackground(serverUrl,jsonData);
        System.out.println(jsonData);
        System.out.println(a);
    }
}
