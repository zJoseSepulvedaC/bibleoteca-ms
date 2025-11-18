package com.biblioteca.zabat.bibleoteca_ms.service.busqueda;

import com.biblioteca.zabat.bibleoteca_ms.entity.Libro;

import java.util.List;

public interface LibroBusquedaStrategy {
    List<Libro> buscar(String valor);
}
