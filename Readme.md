# Conversor de Monedas

Este proyecto es una aplicación de consola desarrollada en Java para realizar conversiones de monedas utilizando datos actualizados obtenidos desde una API. Además, permite guardar las tasas de conversión en archivos JSON para referencia futura.

## Tabla de Contenidos
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Características](#características)
- [Instalación](#instalación)
- [Uso](#uso)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Contribución](#contribución)

## Tecnologías Utilizadas
- **Java**: Lenguaje de programación principal.
- **Gson**: Librería para manejar JSON.
- **API HTTP**: Cliente HTTP para consumir la API de tasas de conversión.

## Características
- Menú interactivo en la consola.
- Consultar tasas de conversión de una moneda base a múltiples monedas objetivo.
- Listar códigos de moneda disponibles junto con sus descripciones.
- Guardar datos de conversión en un archivo JSON con formato legible.
- Manejo de errores para códigos de moneda inválidos o problemas de conexión.

## Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/usuario/conversor-monedas.git
   ```
2. Abre el proyecto en tu IDE favorito (por ejemplo, IntelliJ IDEA o Eclipse).
3. Asegúrate de tener configurado Java 11 o superior.
4. Agrega las dependencias necesarias para Gson y HTTP (si usas Maven, puedes agregar las dependencias en el `pom.xml`).

## Uso

1. Ejecuta la clase `Principal` desde tu IDE o línea de comandos.
2. Sigue las instrucciones en el menú interactivo:
    
### Ejemplo de Conversión:
```
===== Conversor de Monedas =====
1. Consultar conversión de moneda
2. Guardar datos de conversión en archivo JSON
3. Consultar códigos base disponibles
4. Salir
Seleccione una opción: 1
Escriba la moneda de origen (código ISO, por ejemplo, USD): USD
Escriba la moneda de destino (código ISO, por ejemplo, EUR): EUR
Ingrese la cantidad a convertir: 100
100.000000 USD equivalen a 91.580000 EUR
```

### Ejemplo de Códigos Base Disponibles:
```
===== Conversor de Monedas =====
Seleccione una opción: 3
Códigos base disponibles y sus descripciones:
AED - Dirham de los Emiratos Árabes Unidos - Emiratos Árabes Unidos
ARS - Peso argentino - Argentina
AUD - Dólar australiano - Australia
BRL - Real brasileño - Brasil
CAD - Dólar canadiense - Canadá
CHF - Franco suizo - Suiza
CLP - Peso chileno - Chile
CNY - Renminbi chino - China
COP - Peso colombiano - Colombia
EUR - Euro - Unión Europea
GBP - Libra esterlina - Reino Unido
INR - Rupia india - India
JPY - Yen japonés - Japón
MXN - Peso mexicano - México
USD - Dólar estadounidense - Estados Unidos
```

## Estructura del Proyecto
- `ConsultaApiConversion`: Clase que maneja las solicitudes a la API para obtener las tasas de conversión.
- `Conversion`: Clase `record` que representa el modelo de datos retornado por la API.
- `GeneradorDeArchivo`: Clase para guardar los datos de conversión en un archivo JSON.
- `Principal`: Clase principal que implementa el menú interactivo.
    - **Modularidad**: Métodos específicos para realizar la conversión, guardar datos y mostrar códigos base.

## Contribución

¡Las contribuciones son bienvenidas! Si encuentras errores o tienes ideas para mejorar el proyecto, abre un issue o envía un pull request.

1. Crea un fork del proyecto.
2. Crea una rama para tu funcionalidad (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y confirma los commits (`git commit -m 'Agrega nueva funcionalidad'`).
4. Envía un pull request.

---

### Autor
Laura Kees. Trabajo desarrollado como parte del programa ONE de Alura.

