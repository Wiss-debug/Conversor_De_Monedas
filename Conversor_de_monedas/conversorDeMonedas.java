import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class conversorDeMonedas {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/99747b575a605dbc4f6984a3/latest/USD";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("************************************************");
            System.out.println("       Bienvenido/a al Conversor de Moneda =]   ");
            System.out.println("************************************************");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Salir");
            System.out.println("************************************************");
            System.out.print("Elija una opción válida: ");

            option = scanner.nextInt();

            try {
                JsonObject exchangeRates = getExchangeRates();

                switch (option) {
                    case 1:
                        convertDollarToArgentinePeso(scanner, exchangeRates);
                        break;
                    case 2:
                        convertArgentinePesoToDollar(scanner, exchangeRates);
                        break;
                    case 3:
                        convertDollarToBrazilianReal(scanner, exchangeRates);
                        break;
                    case 4:
                        convertBrazilianRealToDollar(scanner, exchangeRates);
                        break;
                    case 5:
                        convertDollarToColombianPeso(scanner, exchangeRates);
                        break;
                    case 6:
                        convertColombianPesoToDollar(scanner, exchangeRates);
                        break;
                    case 7:
                        System.out.println("Saliendo del programa. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error al obtener las tasas de cambio: " + e.getMessage());
            }
        } while (option != 7);

        scanner.close();
    }

    public static JsonObject getExchangeRates() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Parse the JSON response using Gson
        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
        if (!jsonResponse.get("result").getAsString().equals("success")) {
            throw new IOException("Failed to fetch exchange rates.");
        }
        return jsonResponse.getAsJsonObject("conversion_rates");
    }

    public static void convertDollarToArgentinePeso(Scanner scanner, JsonObject exchangeRates) {
        System.out.print("Ingrese la cantidad en dólares: ");
        double dollars = scanner.nextDouble();
        double conversionRate = exchangeRates.get("ARS").getAsDouble();
        double pesos = dollars * conversionRate;
        System.out.printf("La cantidad en pesos argentinos es: %.2f%n", pesos);
    }

    public static void convertArgentinePesoToDollar(Scanner scanner, JsonObject exchangeRates) {
        System.out.print("Ingrese la cantidad en pesos argentinos: ");
        double pesos = scanner.nextDouble();
        double conversionRate = exchangeRates.get("ARS").getAsDouble();
        double dollars = pesos / conversionRate;
        System.out.printf("La cantidad en dólares es: %.2f%n", dollars);
    }

    public static void convertDollarToBrazilianReal(Scanner scanner, JsonObject exchangeRates) {
        System.out.print("Ingrese la cantidad en dólares: ");
        double dollars = scanner.nextDouble();
        double conversionRate = exchangeRates.get("BRL").getAsDouble();
        double reals = dollars * conversionRate;
        System.out.printf("La cantidad en reales brasileños es: %.2f%n", reals);
    }

    public static void convertBrazilianRealToDollar(Scanner scanner, JsonObject exchangeRates) {
        System.out.print("Ingrese la cantidad en reales brasileños: ");
        double reals = scanner.nextDouble();
        double conversionRate = exchangeRates.get("BRL").getAsDouble();
        double dollars = reals / conversionRate;
        System.out.printf("La cantidad en dólares es: %.2f%n", dollars);
    }

    public static void convertDollarToColombianPeso(Scanner scanner, JsonObject exchangeRates) {
        System.out.print("Ingrese la cantidad en dólares: ");
        double dollars = scanner.nextDouble();
        double conversionRate = exchangeRates.get("COP").getAsDouble();
        double pesos = dollars * conversionRate;
        System.out.printf("La cantidad en pesos colombianos es: %.2f%n", pesos);
    }

    public static void convertColombianPesoToDollar(Scanner scanner, JsonObject exchangeRates) {
        System.out.print("Ingrese la cantidad en pesos colombianos: ");
        double pesos = scanner.nextDouble();
        double conversionRate = exchangeRates.get("COP").getAsDouble();
        double dollars = pesos / conversionRate;
        System.out.printf("La cantidad en dólares es: %.2f%n", dollars);
    }
}
