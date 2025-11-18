package com.biblioteca.zabat.bibleoteca_ms.service.busqueda;

import com.biblioteca.zabat.bibleoteca_ms.entity.Libro;
import com.biblioteca.zabat.bibleoteca_ms.repository.LibroRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("generoStrategy")
public class BusquedaPorGenero implements LibroBusquedaStrategy {

    private final LibroRepository repo;

    public BusquedaPorGenero(LibroRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Libro> buscar(String valor) {
        return repo.findByGeneroContainingIgnoreCase(valor);
    }
}
