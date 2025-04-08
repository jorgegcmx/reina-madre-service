Reina Madre Service
Este proyecto es una aplicación Spring Boot que implementa un CRUD con autenticación básica. A continuación, se detallan los pasos para ejecutar el proyecto localmente, tanto de forma tradicional como utilizando Docker, así como las dependencias incluidas en el proyecto.

Dependencias del Proyecto
El proyecto utiliza las siguientes dependencias principales:

Spring Boot Starter Web: Para la creación de aplicaciones web y RESTful.​

Spring Boot Starter Data JPA: Para la integración con JPA y manejo de bases de datos.​

H2 Database: Base de datos en memoria utilizada para pruebas y desarrollo.​

Spring Boot Starter Security: Para la implementación de autenticación y autorización.​

Ejecución del Proyecto de Forma Tradicional
Para ejecutar el proyecto localmente sin Docker, sigue estos pasos:

Clonar el repositorio:

bash
Copiar
Editar
git clone https://github.com/jorgegcmx/reina-madre-service.git
Navegar al directorio del proyecto:

bash
Copiar
Editar
cd reina-madre-service
Compilar y ejecutar el proyecto:

Si utilizas Maven Wrapper (incluido en el proyecto):

bash
Copiar
Editar
./mvnw spring-boot:run
Si tienes Maven instalado globalmente:

bash
Copiar
Editar
mvn spring-boot:run
Acceder a la aplicación:

La aplicación estará disponible en http://localhost:8080.

Ejecución del Proyecto con Docker
El proyecto incluye un Dockerfile que permite construir y ejecutar la aplicación dentro de un contenedor Docker. Para hacerlo, sigue estos pasos:​

Clonar el repositorio (si no lo has hecho ya):

bash
Copiar
Editar
git clone https://github.com/jorgegcmx/reina-madre-service.git
Navegar al directorio del proyecto:

bash
Copiar
Editar
cd reina-madre-service
Construir la imagen de Docker:

bash
Copiar
Editar
docker build -t reina-madre-service .
Ejecutar el contenedor:

bash
Copiar
Editar
docker run -d -p 8080:8080 --name reina-madre-container reina-madre-service
-d: Ejecuta el contenedor en segundo plano (modo "detached").​

-p 8080:8080: Mapea el puerto 8080 del host al puerto 8080 del contenedor.​

--name reina-madre-container: Asigna el nombre "reina-madre-container" al contenedor.​

Acceder a la aplicación:

La aplicación estará disponible en http://localhost:8080.

Detener y eliminar el contenedor (cuando sea necesario):

bash
Copiar
Editar
docker stop reina-madre-container
docker rm reina-madre-container
Notas Adicionales
Autenticación: La aplicación está protegida con autenticación básica. Asegúrate de configurar las credenciales adecuadas para acceder a los endpoints protegidos.
