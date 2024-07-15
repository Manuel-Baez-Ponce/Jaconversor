package com.projectONE.services;

import com.google.gson.Gson;
import com.projectONE.modules.TasaActual;
import com.projectONE.modules.TasaDeCambio;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConnect {

    public static TasaDeCambio obtenerTasaDeCambio (String urlConsulta){
        URI uriConsulta = URI.create(urlConsulta);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uriConsulta)
                .build();
        try {
            HttpResponse<String> response =  client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            return new TasaDeCambio(gson.fromJson(response.body(), TasaActual.class));
        } catch (Exception e) {
            throw new RuntimeException("Falla en la obtencion de la tasa de cambio");
        }
    }
}
