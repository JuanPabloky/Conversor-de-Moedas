package Conversor.currency;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestManager {
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public String getExchangeRate(String apiKey, String baseCurrency, String targetCurrency) {
        URI url = URI.create(BASE_URL + apiKey + "/pair/" + baseCurrency + "/" + targetCurrency);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            throw new RuntimeException("Não foi possivel realizar a conversão!!!");
        }
    }
}