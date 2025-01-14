import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaApiConversion consultaApiConversion = new ConsultaApiConversion();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n===== Conversor de Monedas =====");
            System.out.println("1. Consultar conversión de moneda");
            System.out.println("2. Guardar datos de conversión en archivo JSON");
            System.out.println("3. Consultar códigos de monedas disponibles");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = lectura.nextLine().trim();

            switch (opcion) {
                case "1":
                    realizarConversion(lectura, consultaApiConversion);
                    break;

                case "2":
                    guardarDatosConversion(lectura, consultaApiConversion);
                    break;

                case "3":
                    mostrarCodigosBase();
                    break;

                case "4":
                    System.out.println("Saliendo del programa!");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }

        lectura.close();
    }

    private static void realizarConversion(Scanner lectura, ConsultaApiConversion consultaApiConversion) {
        System.out.print("Escriba la moneda de origen (código ISO, por ejemplo, USD): ");
        var baseCode = lectura.nextLine().trim();

        try {
            Conversion conversion = consultaApiConversion.buscarConversion(baseCode);
            System.out.print("Escriba la moneda de destino (código ISO, por ejemplo, EUR): ");
            var targetCode = lectura.nextLine().trim();

            if (conversion.conversion_rates().containsKey(targetCode)) {
                double tasa = conversion.conversion_rates().get(targetCode);
                System.out.print("Ingrese la cantidad a convertir: ");

                double cantidad = Double.parseDouble(lectura.nextLine().trim());
                double resultado = calcularConversion(cantidad, tasa);

                System.out.printf("%f %s equivalen a %f %s\n", cantidad, baseCode, resultado, targetCode);
            } else {
                System.out.println("Código de moneda de destino no encontrado.");
            }

        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static double calcularConversion(double cantidad, double tasa) {
        return cantidad * tasa;
    }

    private static void guardarDatosConversion(Scanner lectura, ConsultaApiConversion consultaApiConversion) {
        System.out.print("Escriba la moneda de origen (código ISO, por ejemplo, USD): ");
        var baseCode = lectura.nextLine().trim();

        try {
            Conversion conversion = consultaApiConversion.buscarConversion(baseCode);
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(conversion);
            System.out.println("Datos guardados en archivo " + baseCode + ".json");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void mostrarCodigosBase() {
        System.out.println("\nCódigos de monedas disponibles y sus descripciones:");
        Map<String, String> codigosBase = new LinkedHashMap<>();
        codigosBase.put("AED", "Dirham de los Emiratos Árabes Unidos - Emiratos Árabes Unidos");
        codigosBase.put("ARS", "Peso argentino - Argentina");
        codigosBase.put("AUD", "Dólar australiano - Australia");
        codigosBase.put("BRL", "Real brasileño - Brasil");
        codigosBase.put("CAD", "Dólar canadiense - Canadá");
        codigosBase.put("CHF", "Franco suizo - Suiza");
        codigosBase.put("CLP", "Peso chileno - Chile");
        codigosBase.put("CNY", "Renminbi chino - China");
        codigosBase.put("COP", "Peso colombiano - Colombia");
        codigosBase.put("EUR", "Euro - Unión Europea");
        codigosBase.put("GBP", "Libra esterlina - Reino Unido");
        codigosBase.put("INR", "Rupia india - India");
        codigosBase.put("JPY", "Yen japonés - Japón");
        codigosBase.put("MXN", "Peso mexicano - México");
        codigosBase.put("USD", "Dólar estadounidense - Estados Unidos");

        codigosBase.forEach((codigo, descripcion) -> {
            System.out.printf("%s - %s\n", codigo, descripcion);
        });
    }
}

