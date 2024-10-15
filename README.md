# Conversor de Monedas

Este proyecto es una aplicación de consola en Java que permite convertir entre diferentes monedas utilizando tasas de cambio actuales obtenidas de una API externa. El programa ofrece las siguientes conversiones:

- Dólar (USD) a Peso Argentino (ARS)
- Peso Argentino (ARS) a Dólar (USD)
- Dólar (USD) a Real Brasileño (BRL)
- Real Brasileño (BRL) a Dólar (USD)
- Dólar (USD) a Peso Colombiano (COP)
- Peso Colombiano (COP) a Dólar (USD)

El usuario selecciona una opción (por ejemplo, convertir de Dólar a Peso Argentino) e ingresa la cantidad en dólares. El programa realiza la conversión y muestra el resultado.

## Descripción

El programa utiliza la API [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener las tasas de cambio actuales. La aplicación muestra un menú interactivo en la consola para que el usuario seleccione la conversión deseada e ingrese la cantidad de dinero. Posteriormente, se realiza el cálculo y se muestra el resultado en pantalla.

## Requisitos

Para ejecutar este programa, necesitas tener instalado lo siguiente:

- [Java Development Kit (JDK) 17+]
- Conexión a internet para obtener las tasas de cambio.
- Postman
- Biblioteca Gson

