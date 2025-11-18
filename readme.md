# 📘 Biblioteca-MS

**CRUD de Libros con Spring Boot + Oracle Autonomous Database (Wallet)**  

Microservicio desarrollado en **Java Spring Boot**, generado a partir de un **arquetipo Maven propio**,  
que permite gestionar libros de una biblioteca y aplicar patrones de diseño (Service Layer + Strategy).  
Se conecta a una base de datos **Oracle Cloud Autonomous Database** mediante un **Wallet**,  
utilizando **JPA/Hibernate** para la persistencia de datos.

---

## 🧩 Funcionalidades (CRUD + Búsqueda con Strategy)

| Método   | Endpoint                | Descripción                                      |
| :------- | :---------------------- | :----------------------------------------------- |
| `GET`    | `/libros`              | Lista todos los libros                           |
| `GET`    | `/libros/{id}`         | Obtiene un libro por su ID                       |
| `POST`   | `/libros`              | Crea un nuevo libro                              |
| `PUT`    | `/libros/{id}`         | Actualiza un libro existente                     |
| `DELETE` | `/libros/{id}`         | Elimina un libro por su ID                       |
| `GET`    | `/libros/buscar`       | Busca libros según **autor** o **género** (Strategy) |

🧠 El endpoint `/libros/buscar` utiliza el **patrón Strategy** para elegir dinámicamente  
la estrategia de búsqueda según el parámetro `tipo`:

- `tipo=autor` → busca por autor  
- `tipo=genero` → busca por género  

Ejemplos:
- `/libros/buscar?tipo=autor&valor=Tolkien`
- `/libros/buscar?tipo=genero&valor=Fantasía`

---

## 🧱 Estructura del proyecto

```text
src/main/java/com/biblioteca/zabat/bibleoteca_ms/
 ├── controller/
 │   └── LibroController.java          # Controlador REST (CRUD + búsqueda)
 ├── entity/
 │   └── Libro.java                    # Entidad JPA
 ├── repository/
 │   └── LibroRepository.java          # Repositorio CRUD + métodos de búsqueda
 ├── service/
 │   └── LibroService.java             # Capa de servicio (Service Layer)
 ├── service/busqueda/
 │   ├── LibroBusquedaStrategy.java    # Interfaz Strategy
 │   ├── BusquedaPorAutor.java         # Strategy concreta (búsqueda por autor)
 │   └── BusquedaPorGenero.java        # Strategy concreta (búsqueda por género)
 ├── exception/
 │   ├── NotFoundException.java        # Excepción personalizada
 │   └── ApiExceptionHandler.java      # Manejo de errores global
 └── BibliotecaMsApplication.java      # Clase main de Spring Boot

Patrones de diseño implementados
🔹 Service Layer (LibroService)

Se crea una capa de servicio (LibroService) que concentra la lógica de negocio del CRUD de libros:

Validación de existencia de libros.

Encapsulamiento de operaciones sobre el repositorio.

Separación de responsabilidades entre controlador y acceso a datos.

🔹 Strategy (service.busqueda)

Para la funcionalidad de búsqueda se implementa el patrón Strategy:

LibroBusquedaStrategy: interfaz que define la operación buscar(String valor).

BusquedaPorAutor: implementación concreta que busca usando autor.

BusquedaPorGenero: implementación concreta que busca usando genero.

LibroBusquedaContext: contexto que selecciona la estrategia según tipo (autor o genero).

El controlador solo invoca al contexto y no conoce los detalles de cada búsqueda, cumpliendo el principio Open/Closed (fácil de extender con nuevas estrategias).

| Campo              | Tipo     | Descripción         |
| :----------------- | :------- | :------------------ |
| `ID`               | NUMBER   | Identificador único |
| `TITULO`           | VARCHAR2 | Título del libro    |
| `AUTOR`            | VARCHAR2 | Autor del libro     |
| `ANIO_PUBLICACION` | NUMBER   | Año de publicación  |
| `GENERO`           | VARCHAR2 | Género literario    |


