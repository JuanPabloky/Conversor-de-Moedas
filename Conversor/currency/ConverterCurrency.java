package Conversor.currency;
import com.google.gson.Gson;
public class ConverterCurrency {
    static String apiKey = "b9a6222f23fb713c0673729e";

    static Gson gson = new Gson();


    public static double convertUSDtoARS(double valorUSD) {
        String jsonResponse = new RequestManager().getExchangeRate(apiKey, "USD", "ARS");
        return processResponse(valorUSD, jsonResponse);
    }


    public static double convertARStoUSD(double valorARS) {
        String jsonResponse = new RequestManager().getExchangeRate(apiKey, "ARS", "USD");
        return processResponse(valorARS, jsonResponse);
    }


    public static double convertUSDtoBRL(double valorUSD) {
        String jsonResponse = new RequestManager().getExchangeRate(apiKey, "USD", "BRL");
        return processResponse(valorUSD, jsonResponse);
    }

    public static double convertBRLtoUSD(double valorBRL) {
        String jsonResponse = new RequestManager().getExchangeRate(apiKey, "BRL", "USD");
        return processResponse(valorBRL, jsonResponse);
    }

    public static double convertUSDtoCOP(double valorUSD) {
        String jsonResponse = new RequestManager().getExchangeRate(apiKey, "USD", "COP");
        return processResponse(valorUSD, jsonResponse);
    }

    public static double convertCOPtoUSD(double valorCOP) {
        String jsonResponse = new RequestManager().getExchangeRate(apiKey, "COP", "USD");
        return processResponse(valorCOP, jsonResponse);
    }

    private static double processResponse(double valor, String jsonResponse) {
        ExchangeRateData data = gson.fromJson(jsonResponse, ExchangeRateData.class);
        if (data.conversion_rate == null) {
            throw new RuntimeException("Erro ao obter a taxa de câmbio");
        }

        double taxaCambio = data.conversion_rate;
        return valor * taxaCambio;
    }
}

class ExchangeRateData {
    public Double conversion_rate;
}
