Enunciado
=================

El objetivo de este ejercicio es implementar un microservicio "calculadora", usando maven + spring-boot

Este microservicio tiene que exponer un API que debe ser capaz, a partir de unos parámetros de entrada, de realizar operaciones aritméticas. Al ser una versión POC, sólo será capaz de realizar sumas y restas de dos elementos, aunque se prevé que en futuras versiones haya otros tipos de operaciones y de mayor complejidad. También se incluye con este enunciado un jar que contiene un API de traceo de operaciones que debe ser invocado por el microservicio para tracear el resultado de la operación.

## Notas adicionales

* Lo que se busca ver es la manera en que se afronta el problema, no la solución por si misma. En este sentido, no hay una solución correcta, es mucho más interesante el histórico de Git como hilo conductor de lo que se va haciendo. Tener un único commit con todas las actuaciones efectuadas no es aconsejable.

* Se puede usar cualquier librería / versión que se considere necesaria para llevar a cabo la tarea. Los únicos requisitos son:
  * debe ser un proyecto maven (cualquier versión de maven)
  * debe ser un microservicio spring-boot (cualquier versión de spring-boot)

* El entregable debe compilar en una instalación de maven totalmente limpia, debe indicarse en un fichero README tanto los pasos necesarios para generar el jar final como para ejecutarlo (no hace falta mucho detalle).

Solución
=================
## Estructura
- **Controller:** `CalculadoraController` – expone `/api/suma` y `/api/resta`.
- **Service:** `CalculadoraService` – hace la aritmética y llama a tracer.
- **DTO:** `OperacionResponseDTO` – DTO de vuelta para json serializado.
- **External Tracer:** `tracer-1.0.0.jar` – nos da los resultados.
## Requisitos Previos
- Java 17
- Maven 3.x
- Opcional: Postman para probar la API
## Compilación y Ejecución
1. Abre una terminal en el directorio raíz del proyecto.
2. Ejecuta Maven package:

```bash
mvn clean package
```
3. Esto generará el archivo jar en target/calculadora-1.0.0.jar.
4. Ejecuta el jar:

```bash
java -jar target/calculadora-1.0.0.jar
```
5. El servicio estará disponible en `http://localhost:8080`.
## Uso de la API
- **Suma:**
  - Endpoint: `GET /api/suma?a={num1}&b={num2}`
  - Ejemplo: `http://localhost:8080/api/suma?a=5&b=3`
- **Resta:**
  - Endpoint: `GET /api/resta?a={num1}&b={num2}`
  - Ejemplo: `http://localhost:8080/api/resta?a=5&b=3`
## Respuesta
Ambos endpoints devuelven un JSON con el resultado:
```json
{
  "operacion": "suma",
  "a": 1,
  "b": 2,
  "resultado": 3
}
```
## Ejemplo POSTMAN Collection
Para facilitar las pruebas, aquí tienes una colección de Postman que puedes importar:
````json
{
  "info": {
    "name": "Calculadora API",
    "_postman_id": "f9b2a1e5-1234-5678-9101-abcdef123456",
    "description": "Postman collection for testing Calculadora API endpoints",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "item": [
    {
      "name": "Suma",
      "request": {
        "method": "GET",
        "header": [],
        "url": {
          "raw": "http://localhost:8080/api/suma?a=2&b=3",
          "protocol": "http",
          "host": [
            "localhost"
          ],
          "port": "8080",
          "path": [
            "api",
            "suma"
          ],
          "query": [
            {
              "key": "a",
              "value": "2"
            },
            {
              "key": "b",
              "value": "3"
            }
          ]
        }
      },
      "response": []
    },
    {
      "name": "Resta",
      "request": {
        "method": "GET",
        "header": [],
        "url": {
          "raw": "http://localhost:8080/api/resta?a=10&b=4",
          "protocol": "http",
          "host": [
            "localhost"
          ],
          "port": "8080",
          "path": [
            "api",
            "resta"
          ],
          "query": [
            {
              "key": "a",
              "value": "10"
            },
            {
              "key": "b",
              "value": "4"
            }
          ]
        }
      },
      "response": []
    }
  ]
}
````