package com.utez.libreria.service;

import com.utez.libreria.model.Libro;

import java.util.Date;
import java.util.List;

public interface LibroService {
    List<Libro> buscarPorNombre(String nombre);
    List<Libro> buscarPorAutor(String autor);
    List<Libro> buscarPorRangoFechas(Date fechaInicio, Date fechaFin);
    List<Libro> buscarPorGenero(String genero);
    List<Libro> buscarPorFechaDescendente(Date fecha);
    List<Libro> findAll();
}
