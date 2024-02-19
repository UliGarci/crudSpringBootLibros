package com.utez.libreria.controller;

import com.utez.libreria.model.Libro;
import com.utez.libreria.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/libreria")
@CrossOrigin(origins = "*")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping("/libros")
    public ResponseEntity<List<Libro>> obtenerTodosLibros() {
        List<Libro> libros = libroService.obtenerTodosLibros();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Libro> agregarLibro(@RequestBody Libro libro) {
        Libro libroGuardado = libroService.agregarLibro(libro);
        return new ResponseEntity<>(libroGuardado, HttpStatus.CREATED);
    }

    // Otros métodos del controlador para las operaciones CRUD y consultas personalizadas.

    @GetMapping("/buscarPorNombre")
    public ResponseEntity<List<Libro>> buscarPorNombre(@RequestParam String nombre) {
        List<Libro> libros = libroService.buscarPorNombre(nombre);
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @GetMapping("/buscarPorAutor")
    public ResponseEntity<List<Libro>> buscarPorAutor(@RequestParam String autor) {
        List<Libro> libros = libroService.buscarPorAutor(autor);
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @GetMapping("/buscarPorRangoFechas")
    public ResponseEntity<List<Libro>> buscarPorRangoFechas(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
                                                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {
        List<Libro> libros = libroService.buscarPorRangoFechas(fechaInicio, fechaFin);
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @GetMapping("/buscarPorGenero")
    public ResponseEntity<List<Libro>> buscarPorGenero(@RequestParam String genero) {
        List<Libro> libros = libroService.buscarPorGenero(genero);
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @GetMapping("/buscarPorFechaDescendente")
    public ResponseEntity<List<Libro>> buscarPorFechaDescendente(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha) {
        List<Libro> libros = libroService.buscarPorFechaDescendente(fecha);
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }
}
