package com.utez.libreria.repository;

import com.utez.libreria.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByNombreContainingIgnoreCase(String nombre);

    List<Libro> findByAutorContainingIgnoreCase(String autor);

    List<Libro> findByFechaBetween(Date fechaInicio, Date fechaFin);

    List<Libro> findByGeneroIgnoreCase(String genero);

    List<Libro> findByFechaOrderByFechaDesc(Date fecha);
}
