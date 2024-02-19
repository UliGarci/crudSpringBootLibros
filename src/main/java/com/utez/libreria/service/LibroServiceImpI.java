package com.utez.libreria.service;

import com.utez.libreria.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServiceImpI implements LibroService{

    @Autowired
    private LibroRepository libroRepository;


}
