package com.biblioteca.zabat.bibleoteca_ms.service.busqueda;

import com.biblioteca.zabat.bibleoteca_ms.entity.Libro;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class LibroBusquedaContext {

    private final Map<String, LibroBusquedaStrategy> strategies;

    public LibroBusquedaContext(Map<String, LibroBusquedaStrategy> strategies) {
        this.strategies = strategies;
    }

    public List<Libro> buscar(String tipo, String valor) {
        LibroBusquedaStrategy strategy = null;

        if ("autor".equalsIgnoreCase(tipo)) {
            strategy = strategies.get("autorStrategy");
        } else if ("genero".equalsIgnoreCase(tipo)) {
            strategy = strategies.get("generoStrategy");
        }

        if (strategy == null) {
            throw new IllegalArgumentException("Tipo de búsqueda no soportado: " + tipo);
        }

        return strategy.buscar(valor);
    }
}
