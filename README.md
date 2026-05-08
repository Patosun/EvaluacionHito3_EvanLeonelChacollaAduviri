# Evaluacion hito 3 estructura de datos
Para la realizacion del sistema, se utilizo una API rest desarrollada con Spring Boot, la cual implementa arreglos unidimencionales, bidimensionales y listas enlazadas para la administracion de calificaciones de estudiantes, asientes de aula y participantes ordenados por puntaje.
## Requistos para probar el sistema
- Para este sistema se requerira
    - Java 17
    - Maven 3.8+
## Como ejecutar el proyecto
Para ejecutar el proyecto debemos poner en la terminal:
    mvn spring-boot:run
El servidor iniciara en el puerto 8080, por ende la direccion sera:
    http://localhost:8080
## Funcionalidades del sistema
### Calificaciones
El sistema puede almacenar hasta 10 calificaciones en un arreglo fijo mediante los endpoints GET.
En el caso de este sistema seran las siguentes URL's:
GET http://localhost:8080/notas/agregar?valor=85
GET http://localhost:8080/notas/agregar?valor=42
GET http://localhost:8080/notas
GET http://localhost:8080/notas/promedio
GET http://localhost:8080/notas/max
GET http://localhost:8080/notas/min

### Asientos del aula
Para esta parte se creo una matriz de 5x5, la cual simulara lo que es un aula, donde 'L' = libre y 'O' = ocupado.
Para esto se usaran los siguentes endpoints GET:
GET http://localhost:8080/aula
GET http://localhost:8080/aula/ocupar?fila=2&columna=3
GET http://localhost:8080/aula/liberar?fila=2&columna=3
GET http://localhost:8080/aula/ocupados

### Listar estudiantes mediante una lista enlazada
Para esto se uso una lista enlazada la cual se usara para registrar estudiantes con nombre, puntaje e id.

## Estructura del proyecto
Para este apartado se siguio la estructura proporcionada en el documento pdf.
controller/
Model/
Service/
Estructuras/
