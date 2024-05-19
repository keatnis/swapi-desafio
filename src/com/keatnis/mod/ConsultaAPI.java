package com.keatnis.mod;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {

    public Pelicula buscaPelicula(int numeroDePelicula) {
        URI apiURL = URI.create("https://swapi.py4e.com/api/films/" + numeroDePelicula + "/");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(apiURL)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Pelicula.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontro la pelicula");
        }

    }
}
