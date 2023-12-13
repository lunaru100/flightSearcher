package com.example.flight_przemylska_wolska.Connectors;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostRequester extends AsyncTask<String, Void, String> {
    @Override
    public String doInBackground(String... params) {
        String urlString = params[0];
        String jsonData = params[1];

        try {
            // Create URL
            URL url = new URL(urlString);

            // Open connection
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setDoOutput(true);

            // Write data
            try (OutputStream outputStream = urlConnection.getOutputStream()) {
                outputStream.write(jsonData.getBytes());
            }

            // Get response
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    response.append(line);
                }

                return response.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        // Handle the result here
        if (result != null) {
            // Process the server response
        } else {
            // Handle the error
        }
    }
}
