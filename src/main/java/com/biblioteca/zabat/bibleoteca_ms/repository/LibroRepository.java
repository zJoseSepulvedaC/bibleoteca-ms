package com.biblioteca.zabat.bibleoteca_ms.repository;

import com.biblioteca.zabat.bibleoteca_ms.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> { }
