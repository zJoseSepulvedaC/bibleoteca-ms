# 📘 Biblioteca-MS

**CRUD de Libros con Spring Boot + Oracle Autonomous Database (Wallet)**

## 🚀 Descripción

Microservicio desarrollado en **Java Spring Boot** que permite gestionar libros de una biblioteca.  
Se conecta a una base de datos **Oracle Cloud Autonomous Database** mediante un **Wallet**,  
utilizando **JPA/Hibernate** para la persistencia de datos.

---

## 🧩 Funcionalidades (CRUD)

| Método   | Endpoint       | Descripción                  |
| :------- | :------------- | :--------------------------- |
| `GET`    | `/libros`      | Lista todos los libros       |
| `GET`    | `/libros/{id}` | Obtiene un libro por su ID   |
| `POST`   | `/libros`      | Crea un nuevo libro          |
| `PUT`    | `/libros/{id}` | Actualiza un libro existente |
| `DELETE` | `/libros/{id}` | Elimina un libro por su ID   |

---

## 🧱 Estructura del proyecto

```
src/main/java/com/biblioteca/zabat/bibleoteca_ms/
 ├── controller/LibroController.java     # Controlador REST
 ├── entity/Libro.java                   # Entidad JPA
 ├── repository/LibroRepository.java     # Repositorio CRUD
 ├── exception/NotFoundException.java    # Excepción personalizada
 └── exception/ApiExceptionHandler.java  # Manejo de errores global
```

---

## 🗄️ Entidad `LIBRO`

| Campo              | Tipo     | Descripción         |
| :----------------- | :------- | :------------------ |
| `ID`               | NUMBER   | Identificador único |
| `TITULO`           | VARCHAR2 | Título del libro    |
| `AUTOR`            | VARCHAR2 | Autor del libro     |
| `ANIO_PUBLICACION` | NUMBER   | Año de publicación  |
| `GENERO`           | VARCHAR2 | Género literario    |

---

## ⚙️ Tecnologías utilizadas

- Java 17
- Spring Boot 3.5.7
- Spring Data JPA
- Oracle JDBC (ojdbc11)
- Maven
- HikariCP (pool de conexiones)

---

## 🌐 Configuración de conexión (`application.properties`)

```properties
spring.datasource.url=jdbc:oracle:thin:@lkuafzuwzts282m1_low
spring.datasource.username=ADMIN
spring.datasource.password=<tu_clave_oracle>
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.hibernate.ddl-auto=none
spring.jpa.properties.hibernate.default_schema=ABD_ADMIN
spring.jpa.open-in-view=false
```

> ⚠️ El Wallet de Oracle (`Wallet_LKUAFZUWZTS282M1.zip`) debe estar configurado localmente y su ruta definida mediante `TNS_ADMIN`.

---

## 🧪 Ejemplos de uso (Postman o CURL)

**GET todos los libros**

```bash
GET http://localhost:8080/libros
```

**GET por ID**

```bash
GET http://localhost:8080/libros/1
```

**POST nuevo libro**

```json
POST http://localhost:8080/libros
{
  "titulo": "El señor de los anillos",
  "autor": "J.R.R. Tolkien",
  "anioPublicacion": 1954,
  "genero": "Fantasía"
}
```

**PUT actualizar libro**

```json
PUT http://localhost:8080/libros/1
{
  "titulo": "Cien años de soledad",
  "autor": "Gabriel García Márquez",
  "anioPublicacion": 1967,
  "genero": "Novela"
}
```

**DELETE libro**

```bash
DELETE http://localhost:8080/libros/1
```

---

## 👨‍💻 Autor

**Jose Sepúlveda**  
Estudiante de Ingeniería / Full Stack - Universidad ✨  
Repositorio: [github.com/JoseSepulveda/bibleoteca-ms](https://github.com/JoseSepulveda/bibleoteca-ms)

---

📚 _Este proyecto forma parte de la actividad “Desarrollando nuestro microservicio” de la semana 1._
