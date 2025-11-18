package com.biblioteca.zabat.bibleoteca_ms.controller;

import com.biblioteca.zabat.bibleoteca_ms.entity.Libro;
import com.biblioteca.zabat.bibleoteca_ms.service.LibroService;
import com.biblioteca.zabat.bibleoteca_ms.service.busqueda.LibroBusquedaContext;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private final LibroService service;
    private final LibroBusquedaContext busquedaContext;

    public LibroController(LibroService service, LibroBusquedaContext busquedaContext) {
        this.service = service;
        this.busquedaContext = busquedaContext;
    }

    @GetMapping
    public List<Libro> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Libro obtenerPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Libro> crear(@Valid @RequestBody Libro libro,
                                       UriComponentsBuilder uriBuilder) {
        Libro creado = service.crear(libro);
        URI location = uriBuilder.path("/libros/{id}")
                .buildAndExpand(creado.getId())
                .toUri();
        return ResponseEntity.created(location).body(creado);
    }


    @PutMapping("/{id}")
    public Libro actualizar(@PathVariable Long id,
                            @Valid @RequestBody Libro libro) {
        return service.actualizar(id, libro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/buscar")
    public List<Libro> buscar(@RequestParam String tipo,
                              @RequestParam String valor) {
        return busquedaContext.buscar(tipo, valor);
    }
}
