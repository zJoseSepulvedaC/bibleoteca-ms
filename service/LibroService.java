package com.biblioteca.zabat.bibleoteca_ms.service;

import com.biblioteca.zabat.bibleoteca_ms.entity.Libro;
import com.biblioteca.zabat.bibleoteca_ms.exception.NotFoundException;
import com.biblioteca.zabat.bibleoteca_ms.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private final LibroRepository repo;

    public LibroService(LibroRepository repo) {
        this.repo = repo;
    }

    
    public List<Libro> listarTodos() {
        return repo.findAll();
    }

    
    public Libro buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Libro id=" + id + " no encontrado"));
    }

    
    public Libro crear(Libro libro) {
        libro.setId(null); 
        return repo.save(libro);
    }

    
    public Libro actualizar(Long id, Libro datos) {
        Libro actual = buscarPorId(id);
        actual.setTitulo(datos.getTitulo());
        actual.setAutor(datos.getAutor());
        actual.setAnioPublicacion(datos.getAnioPublicacion());
        actual.setGenero(datos.getGenero());
        return repo.save(actual);
    }

    
    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Libro id=" + id + " no encontrado");
        }
        repo.deleteById(id);
    }
}
