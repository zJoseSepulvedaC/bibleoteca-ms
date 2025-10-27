package com.biblioteca.zabat.bibleoteca_ms.controller;

import com.biblioteca.zabat.bibleoteca_ms.entity.Libro;
import com.biblioteca.zabat.bibleoteca_ms.exception.NotFoundException;
import com.biblioteca.zabat.bibleoteca_ms.repository.LibroRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private final LibroRepository repo;
    public LibroController(LibroRepository repo) { this.repo = repo; }

    // GET /libros/{id}
    @GetMapping("/{id}")
    public Libro obtener(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() ->
                new NotFoundException("Libro id=" + id + " no encontrado"));
    }

    // GET opcional: listar todos (ya lo tenías)
    @GetMapping
    public List<Libro> listar() {
        return repo.findAll();
    }

    // POST /libros
    @PostMapping
    public ResponseEntity<Libro> crear(@Valid @RequestBody Libro in, UriComponentsBuilder uriBuilder) {
        in.setId(null); // evitar override
        Libro creado = repo.save(in);
        URI location = uriBuilder.path("/libros/{id}").buildAndExpand(creado.getId()).toUri();
        return ResponseEntity.created(location).body(creado);
    }

    // PUT /libros/{id}
    @PutMapping("/{id}")
    public Libro actualizar(@PathVariable Long id, @Valid @RequestBody Libro in) {
        Libro actual = repo.findById(id).orElseThrow(() ->
                new NotFoundException("Libro id=" + id + " no encontrado"));
        actual.setTitulo(in.getTitulo());
        actual.setAutor(in.getAutor());
        actual.setAnioPublicacion(in.getAnioPublicacion());
        actual.setGenero(in.getGenero());
        return repo.save(actual);
    }

    // DELETE /libros/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!repo.existsById(id)) throw new NotFoundException("Libro id=" + id + " no encontrado");
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
