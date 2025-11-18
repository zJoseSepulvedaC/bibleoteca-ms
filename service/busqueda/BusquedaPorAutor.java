package com.biblioteca.zabat.bibleoteca_ms.service.busqueda;

import com.biblioteca.zabat.bibleoteca_ms.entity.Libro;
import com.biblioteca.zabat.bibleoteca_ms.repository.LibroRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("autorStrategy")
public class BusquedaPorAutor implements LibroBusquedaStrategy {

    private final LibroRepository repo;

    public BusquedaPorAutor(LibroRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Libro> buscar(String valor) {
        return repo.findByAutorContainingIgnoreCase(valor);
    }
}
