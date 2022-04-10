package org.acme.service;

import com.google.gson.Gson;
import org.acme.models.History;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.time.Duration;

public class HttpService {

    private final HttpClient client;

    public HttpService() {
        this.client = HttpClient.newHttpClient();;
    }

    public Boolean createHttpRequestCheckIdentifikator(String identifikator) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8082/nakup/check?identifikator=" + identifikator))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
            return Boolean.getBoolean(response.body());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return false;
    }
}
