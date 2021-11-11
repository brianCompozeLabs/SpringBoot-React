package com.example.restexample.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.restexample.model.Libro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControladorLibro {

    static List<Libro> lista = new ArrayList<>();
    static {

        lista.add(new Libro("titulo1","autor1",200));
        lista.add(new Libro("titulo2","autor2",200));

    }

    @CrossOrigin(origins = "*")
    @GetMapping("/libros")
    public List<Libro> getLibros() {
        return lista;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/libros",consumes="application/json")
    public ResponseEntity insertarLibro( @RequestBody Libro l) {
        lista.add(l);
        return new ResponseEntity(HttpStatus.OK);

    }

}