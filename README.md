
# Reina Madre Service

Este proyecto es una aplicación **Spring Boot** que implementa un CRUD de citas médicas con autenticación básica. Incluye endpoints REST y está preparado para ejecutarse localmente o mediante Docker.

---

## 📦 Dependencias del Proyecto

Incluye las siguientes dependencias principales:

- **Spring Boot Starter Web** – Para construir APIs REST.
- **Spring Boot Starter Data JPA** – Para persistencia con JPA.
- **Spring Boot Starter Security** – Para autenticación básica.
- **H2 Database** – Base de datos en memoria (solo desarrollo).

---

## ▶️ Ejecución local sin Docker

### 1. Clonar el repositorio

```bash
git clone https://github.com/jorgegcmx/reina-madre-service.git
cd reina-madre-service
```

### 2. Ejecutar con Maven

Si usas Maven local:

```bash
mvn spring-boot:run
```

O con Maven Wrapper (incluido):

```bash
./mvnw spring-boot:run
```

### 3. Acceder a la aplicación y swagger

```text
http://localhost:8080  , http://localhost:8080/swagger-ui/index.html#
```

---

## 🐳 Ejecución usando Docker

### 1. Clonar el repositorio

```bash
git clone https://github.com/jorgegcmx/reina-madre-service.git
cd reina-madre-service
```

### 2. Construir la imagen Docker

```bash
docker build -t reina-madre-service .
```

### 3. Ejecutar el contenedor

```bash
docker run -d -p 8080:8080 --name reina-madre-container reina-madre-service
```

- `-d`: Modo detached (segundo plano)
- `-p 8080:8080`: Expone el puerto 8080
- `--name`: Nombre del contenedor

### 4. Acceder a la aplicación

```text
http://localhost:8080
```

### 5. Detener y eliminar el contenedor

```bash
docker stop reina-madre-container
docker rm reina-madre-container
```

---

## 🔐 Autenticación

La aplicación usa **autenticación básica HTTP**.

### Credenciales por defecto (puedes modificarlas en configuración):

```
Usuario: admin
Contraseña: admin
```

---

## 🧪 Base de Datos

- Se usa **H2 en memoria**, por lo que los datos se reinician al cerrar la app.
- La consola de H2 (si está habilitada) puede estar en:
  ```http://localhost:8080/h2-console```
  
---

## ✅ Endpoints de ejemplo

| Método | Endpoint         | Autenticación | Descripción            |
|--------|------------------|----------------|------------------------|
| GET    | `/api/citas`     | Sí             | Listar todas las citas |
| POST   | `/api/citas`     | Sí             | Crear una nueva cita   |
| PUT    | `/api/citas/{id}`| Sí             | Actualizar una cita    |
| DELETE | `/api/citas/{id}`| Sí             | Eliminar una cita      |

---

## 📄 Licencia

Este proyecto es de uso libre para fines educativos y de práctica. Puedes adaptarlo o extenderlo según tus necesidades.

---

## ✨ Autor

Desarrollado por [@jorgegcmx](https://github.com/jorgegcmx)
