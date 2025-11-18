package com.biblioteca.zabat.bibleoteca_ms.repository;

import com.biblioteca.zabat.bibleoteca_ms.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    
    List<Libro> findByAutorContainingIgnoreCase(String autor);

    
    List<Libro> findByGeneroContainingIgnoreCase(String genero);
}
