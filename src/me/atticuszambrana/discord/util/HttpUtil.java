package me.atticuszambrana.discord.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
    public static String get(String input) throws IOException {
    	
    	input = input.replace(" ", "%20");
    	
        HttpURLConnection httpClient =
                (HttpURLConnection) new URL(input).openConnection();

        // optional default is GET
        httpClient.setRequestMethod("GET");
        httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(httpClient.getInputStream()))) {

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        }

    }
}
